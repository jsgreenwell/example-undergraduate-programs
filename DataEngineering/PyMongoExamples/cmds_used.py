#These are the commands I used with Mongo and Python (Linux system)
#Will need to unzip the movies directory into the same directory as program
### For Windows: may need different command to start/stop mongodb
sudo service mongodb start
python ./load_movies.py
python ./analyze_movies.py
sudo service mongodb stop

##if you really, really mess-up (or just insert twice on accident):
mongo
Mongo().getDBNames()
#or
show dbs
#then to delete the ones you need to delete:
Mongo().getDB("DBname").dropDatabase();
