## 빅데이터

대량 ( 수십테라바이트 이상) 의 정형 / 비정형 데이터로 부터 가치를 추출하고 결과를 분석하는 기술.

스마트폰 대중화로 인해 이뤄진 다수의 사용자의 다양한 서비스 이용 에서 발생하는 수많은 데이터를 대상으로 다양한 종류의 대규모 데이터를 생성, 수집, 분석, 표현 현대 사회를 더욱 정확하게 예측, 효율적으로 작동케 하고 개인화된 현대 사회 구성원 마다 맞춤형 정보를 제공, 관리, 분석 을 가능하게 하는 기술.



### 빅데이터 3V 모델

Volume - 데이터 규모  테라바이트 ~ 페타바이트 급의 규모

Velocity - 데이터는 하루 단위에서 실시간에 이르기까지 상대적으로 짧은 시간 내에 수집, 저장, 처리 및 분석되어야 한다.

Variety - 다양한 소스 및 형식의 데이터를 포함 (웹 로그, 소셜 미디어 상호 작용, 전자 상거래 및 온라인 트랜잭션, 금융 트랜잭션 등).

`+` veracity(정확성) , variablilty(가변성) , visualizaition(시각화)

# Hadoop

간단한 프로그래밍 모델을 사용하여 여러대의 컴퓨터 클러스터에서 대규모 데이터 세트를 분산 처리 할 수있게 해주는 자바 기반의 오픈소스 프레임워크이다.

많은 양의 데이터를 저장하기 위한 상용 RDBMS의 하드웨어를 구축하기 위해서는 비용이 상당하지만,

하둡은 오픈소스 Free OS 인 Linux 를 이용하기 때문에 비용적인 부담이 없다.

트랜잭션처리나 무결성 보장에는 적합하지 않기 때문에 RDMBS와 함께 사용된다.

### HDFS

Hadoop Distributed File System (하둡 분산 파일 시스템)

대용량 데이터를 분산된 서버에 저장하고, 다수의 클라이언트가 저장된 데이터를 빠르게 처리할 수 있게 설계된 파일 시스템

분산 처리 시스템인 맵리듀스를 이용해 데이터를 처리/분석 한다.

```
		#기존 대용량 파일시스템
DAS ( direct-attached storage) - 서버에 직접 연결된 storage , 외장하드디스크 와 유사.

NAS (network-attached storage) - 네트워크로 접속하여 사용하는 파일서버. 별도의 os를 사용하고 안정적인 공유할 수 있다. 네트워크 속도에 따라 성능이 좌우된다.

SAN (storage area network) - 다수의 스토리지를 데이터서버에 연결하여 총괄적으로 관리해주는 네트워크. DBMS와 같이 안정적이고 빠른 접근이 필요한 데이터를 저장하는데 사용.
```

HDFS와 기존 대용량 파일 시스템의 큰 차이점은, 저사양 서버를 이용해 스토리지를 구성할 수 있다는 것이다.

HDFS에 저장하는 데이터는 물리적으로 분산된 서버의 로컬디스크에 저장되어 있지만, 읽기 및 저장 등의 제어는 HDFS에서 제공하는 API (맵리듀스) 를 이용한다.

하지만 DBMS처럼 고성능, 고가용성, 트랜잭션처리 가 필요한 경우에는 HDFS가 적합하지 않다. 대규모 데이터를 저장하거나 배치로 처리 하는 경우에 HDFS를 이용하면 된다.

##### HDFS의 장점

1. 장애 복구
2. 스트리밍 방식의 데이터 접근 - 클라이언트의 요청을 빠른시간 내에 처리하는것 보다 동일한 시간 내에 더 많은 데이터를 처리하것을 목표로 한다. 스트리밍 방식으로 데이터에 접근하기 때문에 클라이언트는 끊김없이 연속된 흐름으로 데이터에 접근할 수 있다.
3. 대용량 데이터 저장
4. 데이터 무결성 - 데이터베이스에 저장되는 데이터의 일관성을 의미한다. 데이터의 입력이나 변경 등을 제한하여 데이터의 안전성을 유지한다. 한번 저장된 데이터는 수정할 수 없고, 읽기만 가능하다. 파일 이동, 삭제, 복사는 자유롭다.

#### HDFS 아키텍처

###### 블록 구조 파일 시스템

특정 크기의 블록으로 나눠서 분산된 서버에 저장한다. 블록 크기는 기본적으로 64MB로 설정되어있고 변경이 가능하다.



###### 네임노드

파일시스템의 네임스페이스를 관리한다.

파일시스템 트리와 그 트리에 포함된 모든 파일과 디렉터리에 대한 메타데이터를 유지한다. 네임스페이스 이미지, 에디트 로그 파일로 저장된다. 파일에 속한 모든 블록이 어느 datanode에 있는지 파악하고 있다.

- 메타데이터 관리 - 파일시스템을 유지하기 위한 메타데이타를 관리한다. 파일 시스템 이미지(파일명, 디렉토리 ,크기, 권한) 와 파일에 대한 블록매핑 정보로 구성된다.
- 데이터노드 모니터링 - 데이터노드가 보내는 hearbeat 로 데이터노드의 상태와 용량을 모니터링 한다. 하트비트를 전송하지 않는 데이터노드가 있다면 장애가 있는 것으로 판단한다.
- 블록관리 - 장애가 발생한 데이터노드를 발견하면, 새로운 데이터노드로 복제를 한다. 용량이 부족한 데이터노드가 있다면 블록을 여유가 있는 곳으로 이동시킨다. 블록의 복제본 수도 관리 한다.
- 클라이언트 요청 접수

###### 데이타노드 Datanode

클라이언트가 HDFS에 저장하는 파일을 로컬디스크에 유지한다. 클라이언트나 네임노드의 요청에 의해 블록을 저장, 탐색 한다. 저장하고 있는 블록의 목록을 주기적으로 네임노드에 보고한다.(heartbeat)



###### 보조 네임노드Secondary-NameNode

네임노드가 메타데이터를 메모리에서 처리하기 때문에 재부팅 될 경우 메타데이터의 유실이 발생할 수 있다. 이러한 문제를 해결하기 위해 editslog 와 fsimage 파일을 생성한다.

editslog - HDFS의 모든 변경이력 기록

fsimage - 블록과 데이터노드의 정보를 가진 메타데이터

네임노드가 구동되면 로컬에 저장된 두 파일을 조회하여 메모리에 파일시스템이미지를 생성하고, editlog에 기록된 변경 이력을 적용한다. 메모리에 로딩된 파일시스템이미지를 바탕으로 fsimage를 갱신하고 editslog를 초기화한다.

주 네임노드에 장애가 발생할 것을 대비해서 네임스페이스 이미지의 복제본을 보관하는 역할을 한다. 

네임스페이스의 이미지가 약간의 시간차를 두고 secondary로 복제되기 때문에 어느정도의 데이터 손실은 불가피 하다.



###### 클라이언트의 블럭 조회 과정

##### NoSQL

RDBMS , SQL 문을 사용하지 않는 데이터베이스 시스템 / 데이터저장소를 의미

단순히 키와 값의 쌍으로 이루어져 있고 익덱스와 데이터가 분리되어 별도로 운영된다.

조인이 없고 RDBMS 의 row 를 하나의 집합된 형태로 저장한다. 완벽한 무결성, 정합성을 제공하지않고 데이터를 보관하고 처리하는 경우에 주로 이용된다.

###### HDFS 명령어

```shell
hadoop fs -ls /
hadoop fs -lsr mydir
hadoop fs -du mydir	#용량 출력
hadoop fs -put
hadoop fs -get
hadoop fs -mv from to	#이동
hadoop fs -rmr mydir	#삭제
hadoop fs -expunge		#휴지통비우기
```





#### 하둡의 과제

고가용성 - High Availability

파일 네임스페이스 제한

데이터 수정 불가 

POSIX 명령어 미지원

전문 업체 부족 - 오라클 과 같은 상용DBMS 는 전문업체가 있어 유지보수, 문제해결 방법을 찾기 수월하지만 하둡은 비교적 그렇지 않다.

###### 실행모드

- 독립실행 모드
- 가상 분산 모드 - 하나의 서버에 온전한 하둡 환경을 구축한 것
- 완전 분산 모드 - 둘 이상의 하둡서버를 구축한 것



##ssh

SeciureSHell

네트워크 상의 다른컴퓨터에 로그인하거나 원격시스템에서 명령을 실행하게 해주는 프로그램/프로토콜



##### Setting

가상분산모드

1. 필요 소프트웨어 다운로드

1) java

2) hadoop

3) eclipse

4) tomcat

5) mysql

wget https://archive.apache.org/dist/hadoop/common/hadoop-1.2.1/[hadoop-1.2.1.tar.gz

2. 네트워크 설정

1)etc/hosts

2)etc/hostname  /     hostnamectl -setname hadoopserver1

3)etc/sysconfig/network-scripts

4)systemctl disable firewalld  로 port들을 모두 열어둔다.

3. 패스 설정

etc/profile

HADOOP_HOME=/etc/hadoop-1.2.1

export HADOOP_HOME

PATH=$HADOOP_HOME/bin:$JAVA_HOME/bin:$PATH

export PATH



4. ssh 키 생성

[ssh](#ssh)

키를 통해 접속하면 접속시 마다 id pwd 입력을 하는 번거러움을 덜고 자유롭게 서버들을 오갈 수 있게 만든다.

private key 와 public key 를 이용해서, key가 일치하는 서버끼리는 자유롭게 접속이 가능하다.

```shell
$ ssh-keygen -t dsa -P '' -f ~/.ssh/id_dsa
#dsa 알고리즘을 통해 public, private Key 생성
$ cat /.ssh/id_dsa.pub >> /.ssh/authorized_keys
# 만들어진 authorized_keys를 다른 서버의 ~/.ssh 에 복사하게 되면 자유롭게 접속을 할 수 있게 된다.
```

5. hadoop/conf 내의 configuration 파일 수정

```xml
<!--core-site.xml-->
<configuration>
<property>
  <name>fs.default.name</name>
  <value>hdfs://localhost:9000</value>
  <!--외부에서 namenode를 접속할때의 port를 지정해준다.-->
</property>
<property>
  <name>hadoop.tmp.dir</name>
  <value>/usr/local/hadoop/tmp</value>
</property>
</configuration>

<!--hdfs-site.xml-->
<configuration>
<property>
  <name>dfs.replication</name>
  <value>1</value>
    <!--데이터를 몇개의 형태로 저장할것 인지 지정-->
</property>
<property>
  <name>dfs.name.dir</name>
  <value>/usr/local/hadoop/name</value>
    <!--namenode가 사용하는 정보를 저장하는 디렉토리 지정-->
</property>
<property>
  <name>dfs.data.dir</name>
  <value>/usr/local/hadoop/data</value>
    <!--데이터를 저장하는 디렉토리 지정-->
</property>
<property>
  <name>dfs.webhdfs.enabled</name>
  <value>true</value>
</property>
</configuration>

<!--mapred-site.xml-->
<configuration>
<property>
  <name>mapred.job.tracker</name>
  <value>localhost:9001</value>
    <!--jobtracker로 접근하는 prot 설정-->
</property>
</configuration>

맵리듀스
JOBTRACKER
분석에 대한 요청을 받는곳
TASKTARCKER
실재로 수행을 하는 것
```

6. hadoop-env.sh 수정

```

#8번 라인 수정, 한줄 추가
export JAVA_HOME=/etc/jdk1.8
export HADOOP_HOME_WARN_SUPPRESS="TRUE"
```

7. /etc/bashrc 에 추가 , 부팅시 자동으로 실행

```
. /etc/hadoop-1.2.1/conf/hadoop-env.sh
```

8. hadoop namenode -format       //name 디렉토리가 생성된다.
9. start-all.sh //hadoop 실행, data 디렉토리가 생성된다. jps 로 확인



###### 데이터 넣기 및 처리

```
$ hadoop dfs -mkdir /data
## test 디렉토리 생성
$ hadoop dfs -put README.txt /data/input1
## 하둡서버에 파일 넣기
$ hadoop jar hadoop-examples-1.2.1jar wordcount /data/input1 /data/output1
## examples... 의 wordcount 메소드를 이용해 아웃풋 생성

```



#### 완전분산모드 설정하기

1. ssh 활성화

   ssh-keygen

   public key 를 authorized_keys 로 서버들에게 나누어줘서 자유로운 출입 설정

2. systemctl stop firewalld ,

   systemctl disable firewalld  로 방화벽 완전 해제하기

3. namenode 컴퓨터 hadoop 설치 및 configuration 파일 설정 + /etc/profile , /etc/bashrc 에서 path 설정 하기.

conf/masters 에는 secondaryNamenode 를 담을 server를  지정 , conf/slaves 에는 datanode를 저장할 server를 지정한다.

```
#conf/master
hadoop2

#conf/slaves
hadoop2
hadoop3
hadoop4
```

```xml
<!--core-site.xml-->
<configuration>
<property>
    <name>fs.default.name</name>
    <value>hdfs://hadoop1:9000</value>
  </property>
  <property>
    <name>hadoop.tmp.dir</name>
    <value>/etc/hadoop-1.2.1/tmp</value>
  </property>
</configuration>

<!--hdfs-site.xml-->
<configuration>
  <property>
    <name>dfs.permissions</name>
    <value>false</value>
  </property>
  <property>
    <name>dfs.replication</name>
    <value>2</value>      
  </property>
  <property>
    <name>dfs.http.address</name>
    <value>192.168.111.201:50070</value>
      <!---->
  </property>
  <property>
    <name>dfs.secondary.http.address</name>
    <value>192.168.111.202:50090</value>
      <!--SecondaryNamenode를 가질 서버 지정-->
  </property>
  <property>
    <name>dfs.name.dir</name>
    <value>/etc/hadoop-1.2.1/name</value>
  </property>
  <property>
    <name>dfs.data.dir</name>
    <value>/etc/hadoop-1.2.1/data</value>
  </property>
</configuration>

<!-- mapred-site.xml -->
<configuration>
  <property>
   <name>mapred.job.tracker</name>
   <value>master:9001</value>
  </property> 
</configuration>

```

4. 각 서버에 hadoop 복사 

5. namenode 서버에서 hadoop namenode -format 로 포맷, start-all.sh 로 실행 . 각 서버에서 jps 로 설정한대로 실행 중 인지 확인하기

#### 맵리듀스

HDFS에 저장된 파일을 분산 배치 분석을 할 수 있게 도와주는 프레임워크.

맵, 리듀스 두가지 단계로 데이터를 처리한다.

맵(map) - 

리듀스 -



#### 하이브

하둡에 저장된 데이터를 쉽게 처리할 수 있는 데이터웨어하우스 패키지이다. (맵리듀스 프로그래밍을 쉽게 할수 있도록 도와준다.)

SQL문을 입력하면 hive에서 맵리듀스 프로그래밍이 만들어져 하둡의 JOBTARCKER에게 분석작업을 요청한다. 실제 데이터는 하둡의 datanode에 저장되고, 데이터의 구조 정보가 mariadb에 담기게 된다.

###### 하이브 setting 하기

```mysql
##mysql 데이터베이스에서...
grant all privileges on *.* to 'hive'@'localhost' identified by '111111';
flush privileges;
## hive 에게 권한을 주고, 사용할 database를 생선한다.
create database hive_db;
grant all privileges on hive_db.* to 'hive'@'%' identified by '111111' with grant option;
grant all privileges on hive_db.* to 'hive'@'localhost' identified by '111111' with grant option;
flush privileges;
commit;
```

/etc/profile  에서 path 설정

```
export HIVE_HOME=/usr/local/hive
export HADOOP_HOME=/usr/local/hadoop
PATH=$PATH:$HOME/bin:$HADOOP_HOME/bin:$HIVE_HOME/bin:
```

hive/conf/hive-site.xml 수정 or 생성

```xml
<?xml version="1.0"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<configuration>
    <property>
        <name>hive.metastore.local</name>
        <value>true</value>
        <description>controls whether to connect to remove metastore server or open a new metastore server in Hive Client JVM</description>
    </property>
    
    
    <!-- Maria DB 의 테이블과 jdbc driver, 계정 id 와 pwd 지정-->
    <property>
        <name>javax.jdo.option.ConnectionURL</name>
        <value>jdbc:mariadb://localhost:3306/hive_db?createDatabaseIfNotExist=true</value>
        <description>JDBC connect string for a JDBC metastore</description>
    </property>
    <property>
        <name>javax.jdo.option.ConnectionDriverName</name>
        <value>org.mariadb.jdbc.Driver</value>
        <description>Driver class name for a JDBC metastore</description>
    </property>    
    <property>
        <name>javax.jdo.option.ConnectionUserName</name>
        <value>hive</value>
        <description>username to use against metastore database</description>
    </property>
    <property>
        <name>javax.jdo.option.ConnectionPassword</name>
        <value>111111</value>
        <description>password to use against metastore database</description>
    </property>    
    <property>
        <!--data를 넣을때 hadoop 의 어느 디렉토리에 저장할지 지정.
		밑의 값은 디폴트와 동일 -->
    	<name>hive.metastore.warehouse.dir</name>
        <value>/user/hive/warehouse</value>
    </property>    
    <property>
        <!--hive 내에서 header를 출력-->
    	<name>hive.cli.print.header</name>
        <value>true</value>
    </property>
</configuration>
```

hive를 사용할 디렉토리 생성

```shell
hadoop fs -mkdir /tmp
hadoop fs -mkdir /user/root/warehouse
hadoop fs -chmod g+w /tmp
hadoop fs -chmod g+w /user/root/warehouse
hive 
-- error ## /tmp/hive 디렉토리가 생성된다.
hadoop fs -chmod 777 /tmp/hive 
```

```mysql
create table post(date1 string, date2 string, cmd string, id string) PARTITIONED BY (date INT) row format delimited fields terminated by ',' stored as textfile;
## 데이터 파일의 한 줄을 , 를 이용해서 각 attribute를 나누겠다.
load data local inpath '/root/data/2008.csv' overwrite into table airline_delay partition (delayYear='2008');
##저장할 때에 delayyear=2008의 파티션을 생선하고 그곳에 데이터를 넣는다.
##아주 많은 양의 데이터를 저장하기 때문에 원하는 

select * from airline_delay where delayyear='2007' LIMIT 10;


ROW FORMAT DELIMITED
    FIELDS TERMINATED BY ','
    LINES TERMINATED BY '\n'
    STORED AS TEXTFILE;

load data local inpath '/root/hdi.txt' into table HDI;
##파일을 hive 디렉토리 안에 이동 , hdi.txt 의 내용을 hdi table 의 column에 맞춰 들어가게 된다.
```

###### 하이브QL

- UPDATE 와 ELETE를 사용할수 없다.
- FROM절 에서만 서브 쿼리를 사용할 수 있다.
- 뷰는 읽기 전용이며 비구체화된 뷰만 지원한다.
- HAVING 절을 사용 할 수 없다.
- 저장 프로시져(stored procedure)를 지원하지 않는다.



###### Java Application 으로 하이브 돌리기

```shell
hive --service hiveserver2
## hive 위의 listener 역할을 하는 녀석을 준비상태로 실행시킨다.
```

App.java

```java
 Class.forName("org.apache.hive.jdbc.HiveDriver");
 Connection conn =DriverManager.getConnection("jdbc:hive2://70.12.114.207:10000/default","root","111111");
//hive2 서버를 구동하고있는 ip주소로 접속한다. id / pwd 입력 (익명으로 로그인시 생략 가능)
        Statement stmt =conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM airline_delay");
        while(rs.next()) {
             System.out.println(rs.getString(1) + " " +rs.getString(5));             
           }
        conn.close();
```

