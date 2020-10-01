import pandas as pd
from flask import Flask, json
from pytrends.request import TrendReq
pytrends = TrendReq(hl='en-US', tz=360)
api = Flask(__name__)

@api.route('/', methods=['GET'])
def get_companies():
keywords = ['Python', 'R']
pytrend.build_payload(
     kw_list=keywords,
     cat=0,
     timeframe='today 3-m',
     geo='TW',
     gprop='')
data = pytrend.interest_over_time()
  return print(data)

if __name__ == '__main__':
    api.run()