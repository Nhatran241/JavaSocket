import pandas as pd
import datetime
from flask import Flask, json
from flask import request
from pytrends.request import TrendReq
api = Flask(__name__)

@api.route('/search')
def trend():
  rkeyword = request.args.get("q", default = "", type = str).replace("'", "")
  rcat = request.args.get('cat', default = "", type = str)
  rgeo = request.args.get('geo', default = "", type = str)
  rdatefrom = request.args.get('from', type = str).replace("'", "")
  rdateto = request.args.get('to', type = str).replace("'", "")

  pytrend = TrendReq(hl='en-US', tz=360)
  pytrend.build_payload(kw_list=['trump'],geo=rgeo,cat=rcat,timeframe=rdatefrom+' '+rdateto)
  # Interest by Region
  result='[{interest_by_region:'
  interest_by_region_df = pytrend.interest_by_region()
  result+=interest_by_region_df.to_json(orient="split")+"},"
  # Related Queries, returns a dictionary of dataframes
  related_queries_dict = pytrend.related_queries()
  temp=''
  temp+=iterdict(related_queries_dict,temp)
  result+='{related_queries:{'+temp+'}}]'
  return result

@api.route('/categories')
def getCategories():
    pytrend = TrendReq(hl='en-US', tz=360)
    result = pytrend.categories()
    return json.dumps(result)

def iterdict(d,result):
    pandas = pd
    for k,v in d.items():
        if isinstance(v, dict):
            result+=iterdict(v,result)
        else:
            if type(v) == pandas.core.frame.DataFrame:
                result+=k+':'+v.to_json(orient="split")+','
    return result
if __name__ == '__main__':
    api.run()
