# Session Management Client Service #
This is a simple session management client service build using Java Spring boot and uses redis as in memory database. Supports String and HashMap    

To get started simply include it as a new module in the `settings.gradle` file.

Eg:
```
rootProject.name = 'Auth-Service'

include('app')
include('session-manager')
project(':app').projectDir = file('app')
```

### *Step 1: Start redis server*  ###
Install and start redis server with the `redis-server` command

### *Create Instance of Redis Service class* ###
Use @Autowired in application to auto inject RedisService class.

```
@Autowired
RedisService redisService
```

RedisService class provides methods to Set, Get & Delete String and HashMap data from database.

Methods provided by RedisService class are
* StringDTO setString(StringDTO stringDTO) throws Exception
* StringDTO getString(String key) throws Exception
* boolean deleteString(String key) throws Exception
* HashMapDTO setToHashMap(HashMapDTO hashMapDTO) throws Exception
* HashMapDTO getFromHashMap(String hashName, String key) throws Exception
* boolean deleteFromHashMap(String hashName, String key) throws Exception
