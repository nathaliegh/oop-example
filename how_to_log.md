# How to Log

1. ```shell
   cd /docker
   ```

2. ```shell
   docker-compose up -d
   ```

3. ```text
   check the elastic credentials inside /docker/logstash/pipeline/logstash.conf
   ```

4. login in kibana
   [login kibana](http://localhost:5601/login?next=%2F)

5. add index pattern 
    * open the link [Kibana index pattern](http://localhost:5601/app/kibana#/management/kibana/index_patterns?_g=())
    * create an index has name (logstash.*)

6. check the indexes patterns list on opening the link
   [Elastic index](http://localhost:9200/_cat/indices)

7. view the logs in [Discover logs](http://localhost:5601/app/kibana#/discover?_g=())
   