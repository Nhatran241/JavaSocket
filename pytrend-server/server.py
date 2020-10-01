import pandas as pd
from flask import Flask, json
from pytrends.request import TrendReq
api = Flask(__name__)

@api.route('/', methods=['GET'])
def trend():
  pytrend = TrendReq(hl='en-US', tz=360)
  pytrend.build_payload(kw_list=['covid'])
  interest_over_time_df = pytrend.interest_over_time()
  result = interest_over_time_df.head().to_json(orient="split")
  return result
if __name__ == '__main__':
    api.run()
