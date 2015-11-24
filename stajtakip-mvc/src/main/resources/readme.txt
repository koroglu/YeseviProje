mvn install:install-file -Dfile=D:\Oracle\Middleware\Oracle_Home\oracle_common\modules\oracle.jdbc_12.1.0\ojdbc6.jar -Dpackaging=jar  -DgroupId=com.oracle.weblogic -DartifactId=wlclient -Dversion=12.1.0


HSQLDB Çalıştırmak İçin
--------------------------------
java -cp hsqldb.jar org.hsqldb.Server -database.0 file:C:\Users\ukilic\git\YeseviProje\stajtakip-mvc\src\main\resources\hsqldb\stajdb -dbname.0 stajdb

