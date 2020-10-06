import pandas as pd
import datetime
from flask import Flask, json
from flask import request
from pytrends.request import TrendReq
api = Flask(__name__)

@api.route('/search')
def trend():
  rkeyword = request.args.get("q", default = "", type = str).replace("'", "")
  rcat = request.args.get('cat', default = 0, type = int)
  rgeo = request.args.get('geo', default = 0, type = int)
  rdatefrom = request.args.get('from', type = str).replace("'", "")
  rdateto = request.args.get('to', type = str).replace("'", "")

  pytrend = TrendReq(hl='en-US', tz=360)
  pytrend.build_payload(kw_list=['trump'],geo='US')

  # Interest Over Time
  interest_over_time_df = pytrend.interest_over_time()
  print(interest_over_time_df.head())

  # Interest by Region
  interest_by_region_df = pytrend.interest_by_region()
  print(interest_by_region_df.head())
  result+=interest_by_region_df.head().to_json(orient="split")

  # Related Queries, returns a dictionary of dataframes
  related_queries_dict = pytrend.related_queries()
  print(related_queries_dict)

  # Get Google Hot Trends data
  trending_searches_df = pytrend.trending_searches()
  print(trending_searches_df.head())
  result+=trending_searches_df.head().to_json(orient="split")

  # Get Google Hot Trends data
  today_searches_df = pytrend.today_searches()
  print(today_searches_df.head())
  result+=today_searches_df.head().to_json(orient="split")

  # Get Google Top Charts
  top_charts_df = pytrend.top_charts(2018, hl='en-US', tz=300, geo='GLOBAL')
  print(top_charts_df.head())

  # Get Google Keyword Suggestions
  suggestions_dict = pytrend.suggestions(keyword='pizza')
  print(suggestions_dict)

  print(result)
  return result

if __name__ == '__main__':
    api.run()
