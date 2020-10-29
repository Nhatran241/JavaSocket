import pandas as pd
import copy
import datetime
from flask import Flask, json
from flask import request
from pytrends.request import TrendReq
api = Flask(__name__)

@api.route('/searchinterest')
def searchi():
  rkeyword = request.args.get("q", default = "", type = str).split(',')
  rcat = request.args.get('cat', default = "", type = str)
  rgeo = request.args.get('geo', default = "", type = str)
  rdatefrom = request.args.get('from', type = str).replace("'", "")
  rdateto = request.args.get('to', type = str).replace("'", "")
  pytrend = TrendReq(hl='en-US', tz=360)
  if rdatefrom != "" and rdateto != "" :
      if rgeo !="" and rcat != "" :
        print("full")
        pytrend.build_payload(kw_list=rkeyword,geo=rgeo,cat=rcat,timeframe=rdatefrom+" "+rdateto)
      else :
        if rgeo != "" :
          print("no cat")
          pytrend.build_payload(kw_list=rkeyword,geo=rgeo,timeframe=rdatefrom+' '+rdateto)
        else :
          if rcat != "" :
            print("no geo")
            pytrend.build_payload(kw_list=rkeyword,cat=rcat,timeframe=rdatefrom+' '+rdateto)
          else :
            print("no geo no cat")
            pytrend.build_payload(kw_list=rkeyword,timeframe=rdatefrom+' '+rdateto) 
  else :
        if rgeo !="" and rcat != "" :
          print("full no date")
          pytrend.build_payload(kw_list=rkeyword,geo=rgeo,cat=rcat)
        else :
          if rgeo != "" :
            print("no cat no date")
            pytrend.build_payload(kw_list=rkeyword,geo=rgeo)
          else :
            if rcat != "" :
              print("no geo no date")
              pytrend.build_payload(kw_list=rkeyword,cat=rcat)
            else :
              print("no geo no cat nodate")
              pytrend.build_payload(kw_list=rkeyword)
  # Interest by Region
  result=interest_by_region_df = pytrend.interest_by_region().to_json(orient="split")
  return result

@api.route('/searchrelatedtopic')
def searcht():
  rkeyword = request.args.get("q", default = "", type = str).split(',')
  rcat = request.args.get('cat', default = "", type = str)
  rgeo = request.args.get('geo', default = "", type = str)
  rdatefrom = request.args.get('from', type = str).replace("'", "")
  rdateto = request.args.get('to', type = str).replace("'", "")
  pytrend = TrendReq(hl='en-US', tz=360)
  if rdatefrom != "" and rdateto != "" :
      if rgeo !="" and rcat != "" :
        print("full")
        pytrend.build_payload(kw_list=rkeyword,geo=rgeo,cat=rcat,timeframe=rdatefrom+" "+rdateto)
      else :
        if rgeo != "" :
          print("no cat")
          pytrend.build_payload(kw_list=rkeyword,geo=rgeo,timeframe=rdatefrom+' '+rdateto)
        else :
          if rcat != "" :
            print("no geo")
            pytrend.build_payload(kw_list=rkeyword,cat=rcat,timeframe=rdatefrom+' '+rdateto)
          else :
            print("no geo no cat")
            pytrend.build_payload(kw_list=rkeyword,timeframe=rdatefrom+' '+rdateto) 
  else :
        if rgeo !="" and rcat != "" :
          print("full no date")
          pytrend.build_payload(kw_list=rkeyword,geo=rgeo,cat=rcat)
        else :
          if rgeo != "" :
            print("no cat no date")
            pytrend.build_payload(kw_list=rkeyword,geo=rgeo)
          else :
            if rcat != "" :
              print("no geo no date")
              pytrend.build_payload(kw_list=rkeyword,cat=rcat)
            else :
              print("no geo no cat nodate")
              pytrend.build_payload(kw_list=rkeyword)
 
  # Related topic, returns a dictionary of dataframes
  related_queries_dict = pytrend.related_topics()
  result=''
  d = nested_dicts(copy.deepcopy(related_queries_dict))
  return d

@api.route('/searchrelatedquery')
def searchr():
  rkeyword = request.args.get("q", default = "", type = str).split(',')
  rcat = request.args.get('cat', default = "", type = str)
  rgeo = request.args.get('geo', default = "", type = str)
  rdatefrom = request.args.get('from', type = str).replace("'", "")
  rdateto = request.args.get('to', type = str).replace("'", "")
  pytrend = TrendReq(hl='en-US', tz=360)
  if rdatefrom != "" and rdateto != "" :
    if rgeo !="" and rcat != "" :
      print("full")
      pytrend.build_payload(kw_list=rkeyword,geo=rgeo,cat=rcat,timeframe=rdatefrom+" "+rdateto)
    else :
      if rgeo != "" :
        print("no cat")
        pytrend.build_payload(kw_list=rkeyword,geo=rgeo,timeframe=rdatefrom+' '+rdateto)
      else :
        if rcat != "" :
          print("no geo")
          pytrend.build_payload(kw_list=rkeyword,cat=rcat,timeframe=rdatefrom+' '+rdateto)
        else :
          print("no geo no cat")
          pytrend.build_payload(kw_list=rkeyword,timeframe=rdatefrom+' '+rdateto) 
  else :
      if rgeo !="" and rcat != "" :
        print("full no date")
        pytrend.build_payload(kw_list=rkeyword,geo=rgeo,cat=rcat)
      else :
        if rgeo != "" :
          print("no cat no date")
          pytrend.build_payload(kw_list=rkeyword,geo=rgeo)
        else :
          if rcat != "" :
            print("no geo no date")
            pytrend.build_payload(kw_list=rkeyword,cat=rcat)
          else :
            print("no geo no cat nodate")
            pytrend.build_payload(kw_list=rkeyword)
  # Related Queries, returns a dictionary of dataframes
  related_queries_dict = pytrend.related_queries()
  result=''
  d = nested_dicts(copy.deepcopy(related_queries_dict))
  return d

@api.route('/categories')
def getCategories():
    pytrend = TrendReq(hl='en-US', tz=360)
    result = pytrend.categories()
    return json.dumps(result)

@api.route('/suggestions')
def getSuggestions():
    rkeyword = request.args.get("keyword", default = "", type = str).replace("'", "")
    pytrend = TrendReq(hl='en-US', tz=360)
    result = pytrend.suggestions(rkeyword)
    return json.dumps(result)  

def nested_dicts(d):
  try:
    for k, v in d.items():
        if isinstance(v, pd.DataFrame):
            d[k] = v.to_json(orient="split")
        else:
            d[k] = nested_dicts(v)
    return d
  except:
    return d


def iterdict(d,result):
    pandas = pd
    for k,v in d.items():
        if isinstance(v, dict):
            result+=iterdict(v,result)
        else:
            if type(v) == pandas.core.frame.DataFrame:
              print(v)
              result+=k+':'+v.to_json(orient="split")+','
    return result
if __name__ == '__main__':
    api.run()
