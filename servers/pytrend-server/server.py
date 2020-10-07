import pandas as pd
import datetime
from flask import Flask, json
from flask import request
from pytrends.request import TrendReq
api = Flask(__name__)

@api.route('/search')
def trend():
  rkeyword = request.args.get('q', default = "", type = str)
  rcat = request.args.get('cat', default = 0, type = int)
  rgeo = request.args.get('geo', default = 0, type = int)
  rdatefrom = request.args.get('from', type = str)
  rdateto = request.args.get('to', type = str)
  
  pytrend = TrendReq(hl='en-US', tz=360)
  kw_list = rkeyword
  pytrend.build_payload('trump', cat=0, timeframe='today 5-y', geo='', gprop='')
  interest_over_time_df = pytrend.interest_over_time()
  result = interest_over_time_df.head().to_json(orient="split")
  return result

if __name__ == '__main__':
    api.run()
