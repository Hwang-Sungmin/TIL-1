## 객체지향언어

##### I.발생

실제세계는 사물(객체)로 이루어져 있고, 사물간의 상호작용으로 사건들이 발생한다.

이를 컴퓨터 속에서 구현하고 모의실험(simulation) 하기 위해 만들어졌고, 빠르게 변화하는 요구사항들에 맞춰 코드를 변경하기가 까다로운 절차적언어의 한계를 극복을 위해 사용된다.

특징

1. 코드 재사용성이 높다
2. 코드 관리가 용이하다.
3. 신뢰성이 높은 프로그래밍이 가능하다.

## 클래스와 객체

**클래스** 객체를 저의해 놓은것. 객체를 생성하는데 사용된다.
 **객체** 실제로 존재하는것, 사물 혹은 개념. 기능과 속성에 따라 정의된다.

**인스턴스화** 클래스로부터 객체를 만드는 과정. 객체를 그 클래스의 인스턴스(instance) 라고 한다.

##### **객체의 구성요소** 

###### 속성 : 멤버변수 , 특성 , 필드 , 상태

###### 기능 : 메서드 , 함수 , 행위

| 현실 | OOAD (객체지향 분석설계) | OOP (객체지향 프로그래밍) |
| ---- | ------------------------ | ------------------------- |
|      | UML                      | Java / C++ /C#            |

Class and Object

Attribute(속성) , Constructor(생성자) , Function(함수)





### 변수의 종류

선언한 위치에 따라 변수의 종류가 달라진다.

```java
public int iv;
public static int cv;
```

1. 인스턴스변수
   - 클래스 영역에 선언하며, 클래스의 인스턴스가 생성될 때 만들어지고 각각의 인스턴스들은 독립적인 값을 가질 수 있다.
2. 클래스변수
   - 클래스 영역 안에 선언할 때 static 을 붙여 준다. 
   - Method Area에 만들어진다.
   - 모든 인스턴스가 공통된 변수를 공유하게 된다. 따라서 한클래스의 모든 인스턴스들이 공통적인 값을 유지해야 할 경우 클래스변수로 선언할 필요가 있다.
3. 지역 변수
   - 메서드 내에 선언되어 그 메서드에서만 사용가능하고, 메서드가 종료되면 소멸되게된다.
   - 또한, for 문 이나 while 문 의 블럭{} 안에 선언된 경우 그 블럭 안에서만 사용되고, 그 뒤로는 소멸된다.

### 메소드

특정 작업을 수행하는 문장의 묶음.

기능의 구현

함수의 argument에 배열이 들어갈 수 있다. 또한, 함수의 Return Type이 배열이 될 수 있다.

함수의 argument 가 배열일때 ... 으로 표현이 가능하다.



##### 메소드 사용의 장점

1. 높은 재사용성
2. 중복된 코드의 제거
3. 프로그램의 구조화

##### static method

클래스에 정의된 함수를 객체를 통하지 않고 사용하기 위해선 그 함수가 static 으로 정의되어 있어야 한다.  

모든 인스턴스에 공통으로 사용하는 메소드에 static을 붙이고, 인스턴스의 생성 없이 사용할 수 있다.

static methond 에서는 인스턴스 변수를 사용할 수 없다. ( 생성없이 호출이 가능하기 때문에 )

```java
public Class Calc{
	public static int some(int[] a) { // CalClass.java
		int sum = 0;
		for (int i : a)
			sum += i;
		return sum;
	}
}
	System.out.println(Calc.some(arr)); //main.java

```

##### OOP

1. Encapsulation

   클래스의 속성에 대한 접근에 제한을 두어서 값을 보호할수 있게한다.

   접근을 위해서는 getter 와 setter 를 이용한다.

   속성의 값의 범위를 제한하고 이에 맞는 값들만 갖게 하는 것에 용이하다.

2. Inheritance

3. Polymorphism ( 다형성)

   의미는 같지만, 동작이 이루어지는 방식이나 표현방법이 다르다.

   

   이를 구현하기 위해서는 ingeritance 가 필요하다.

   - Abstraction  //추상화

   - Override //재정의

     - 이름이 같아야 한다.

     - 매개변수가 같아야한다.

     - 반환타입이 같아야한다.

       - 조상클래스의 메소드보다 많은 수의 예외를 선언할 수 없다.

       - 인스턴스메소드를 static메소드로 또는 그 반대로 변경할 수 없다.
       - 조상클래스의 static메소드를 재정의 할 수 없다.

   - Overload //

##### this.

현재 움직이고 있는 객체의 주소를 가리킨다.

#### Overloading

같은 이름의 메소드를 다른 argument 갖는 여러개의 메소드로 정의할 수 있다.

함수의 retrun type을 바꾸어 Overloading 할 수 있다.

overloading 한 메소드를 통해 여러가지 argument 를 다룰 수 있다. 한가지 기능을 가진 메소드를 알고 있다면 다른 함수를 알 필요 없이 다양한 argument 의 입력을 다룰 수 있게 되는것이다.

#### Contsructor

인스턴스의 초기화를 하는 메소드.

클래스의 이름과 같아야 한다.

리턴 값이 존재 하지 않는다.

```java
Contructor(){// this is default Constructor    
}
```

클래스 안에 어떠한 Constructor 가 존재 하지 않으면, 생성을 할때에 자동으로 default Constructor 가 실행되고, 인스턴스들의 값이 초기화 세팅이 된다.

하지만 argument를 가진 Constructor 만 존재한다면 default Constructor가 자동으로 실행되지 않는다.

생성자에서 다른 생성자를 호출하여 사용할 수 있다.

 this()를 통해 다른 생성자를 호출한다.

다른 생성자를 호출할 때는 반드시 첫 줄에서만 가능하다.

``` java
Cons(){ 
    this(int a, int b);
}
Cons(int a,int b){
    this.sum = a+b;
}
```

#### Initialization Block

객체가 생성될때 인스턴스 변수와 클래스 변수 의 초기화를 시켜준다.

```java
{
 //각각의 인스턴스가 생성될 때 마다 수행한다.
}
static{
  //인스턴스가 최초 생설될 때만 수행한다.
}
```

### 상속 ( inheritance)

같은 내용의 인스턴스를 갖는 클래스가 2개 이상일 경우에 상속을 이용하여 간단하게 표현할 수 있다. 

모든 java 클래스는 java.Object를 상속받고 있으나 표현하지 않는다.

부모클래스는 한개만 가능하다.

![1558918788154](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1558918788154.png)

*Employee 의 속성을 Manager 가 모두 갖고 있을때. Employee 가 Parent, Manger 가 Child 가 된다.*

​		public : 접근을 제한이 없음
​		protected : 동일한 패키지 내에 존재하거나 파생클래스에서만 접근 가능
​		default : 아무런 접근 제한자를 명시하지 않으면 default 값이 되며, 동일한 패키지 내에서만 접근이 가능
​		private : 자기 자신의 클래스 내에서만 접근이 가능



생성자와 초기화 블럭은 상속되지 않고, 멤버(변수 , 함수) 만 상속된다.

상속관계일 때는 [is a] 관계가 성립해야 한다.

ex)`Manager is a Employee`

만약 has a 관계라면 포함관계(include) 를 맺어주는 것이 옳다.

ex)`Circle has a point`



#### 추상클래스(abstract)

만약 상속을 받는 Child 클래스들이 모두 정의가 다른 하나의 함수를 사용한다고 할때에는 그 함수를 abstract 로 선언을 해준다.

이 클래스를 상속 받으려면 반드시 abstract로 선언된 함수의 재정의가 필요하다.

```java
public abstract class Shape { // 부모 클래스
	public abstract double getArea(); // 추상함수 선언, 정의는 하지 않는다.
} 
public class Rectangle extends Shape{
    @Override
    public double getArea(){
        return Area;
    }
}
```

`super` 를 자손 클래스에서 조상클래스로 부터 상속받은 멤버들에 접근할 수 있다.

#### Heterogeneous Collection

서로 다른 종류의 클래스들을 하나의 집합체로 구현할 수 있다.

아래의 Circle , Triangle ,Rectangle 클래스가 모두 Shape를 상속 받을때 가능하다.

##### (Polymorphism)

조상 클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조할 수 있다.

```java
Shape s[] = new Shape[3];
s[0] = new Circle(new Point(3, 3), 5);
s[1] = new Triangle(new Point(1, 1), 5, 6);
s[2] = new Rectangle(new Point(1, 1), 4, 5);
```

만약, Circle 에만 정의된(specialization 된) 함수를 실행시키고 싶다면, 그에 맞는 TypeCasting 이 필요하다.

```java
((Circle) s[0]).fillColor("BloodRed");
// Circle c= (Circle) sh; 
// c.fillColor();
```

모든 클래스는 java.Object를 상속 받고 있기 때문에 모든 클래스는 Object에 선언될 수 있다.

### 제어자(modifier)

클래스 , 변수 또는 메소드의 선언부에 사용되어 부가적인 의미를 부여한다.



`접근제어자`public, protected , default , private

| 제어자    | 같은클래스 | 같은 패키지 | 자손클래스 | 전체 |
| --------- | ---------- | ----------- | ---------- | ---- |
| public    | o          | o           | o          | o    |
| protected | o          | o           | o          | x    |
| default   | o          | o           | x          | x    |
| private   | o          | x           | x          | x    |



- static - 클래스의, 공통적인
- final - 마지막의 ,변경될 수 없는 
  - final class 는 상속할 수 없고, final method 는 재정의 할 수 없다.
- abstract - 추상의, 미완성의



collection API

1. Set - 중복 불가, 순서 없음
2. List - 순서 있음, 속도 느림
3. Hash - Key, Value 로 짝지어져 있다.



## 인터페이스 (interface)

일종의  완전 추상클래스이다.  

인터페이스 에서의 모든 변수는 상수여야하고,  모든 메소드는 추상 메소드여야 만 하고 그 외의 모든 요소는 허용하지 않는다. 

따라서 인터페이스 내의 변수 선언에서 public static final 과 메소드 선언의 public abstract는 생략이 가능하다. (단, static 메서드와 default 메소드는 예외)

추상클래스가 `미완성 설계도` 라면  인터페이스는 `기본 설계도` 이다. 때문에 다른 클래스를 작성하는데에 도움을 줄 목적으로 사용된다.

클래스를 사용하는 쪽과 클래스를 제공하는 쪽이 있다.

사용하는 쪽에서는 메소드의 선언부만 알면 된다.(내용은 몰라도 된다)

###### 장점

- 개발시간 단축
- 표준화가 가능
- 서로 관계없는 클래스들 사이에 관계를 맺어 줄 수 있다.
- 독립적인 프로그래밍이 가능하다.



## Thread

프로세스 : OS로 부터 실행에 필요한 자원을 할당받은 프로그램.

쓰레드 :  프로세스가 생성한 동시 수행가능한 작업 단위. 프로세스가 할당 받은 자원을 공유한다.

프로세스로의 자원을 함께 나눠 쓰기 때문에 메모리 활용 차원에서 이득이다.



```java
class myThread extends Thread{ 
    // Thread 를 상속 받아 새로운 쓰레드를 정의할수 있다
    String name;
	public MyThread(String name) {
		this.name = name;
	}
	@Override
	public void run() {// Thread 가 수행할 작업을 run 메소드로 정의해준다.
		for(int i=0;i<20;i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " "+i);
		}
	}   
}

class MYThread2 implements Runnable{ // extends를 이용해 상속을 받으면 다른 부모를 둘수 없기 때문에 다른 부모가 필요할 경우 Runnable 인터페이스를 이용한다.
	String name;
	public MYThread2(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name + " "+i);
		}
	}
}

MYThread2 a = new MYThread2("number1");
Thread t= new Thread(a);
t.start();
//Runnable 을 Thread를 이용하여 실행할 수 있다.
```

setDaemon();

메인 쓰레드가 종료가 되면 해당 쓰레드도 종료시킨다.

```java
st.setDaemon(true);
st.start();
for(int i=0;i<10;i++) {
    Thread.sleep(500);
    System.out.println(i);
}
```

#### 쓰레드 실행제어

interrupt - 해당 쓰레드의 interrupted 상태를 변경시킨다.

```java
th1.interrupt();

if(isInterrupted()){
    //로 상태를 확인할 수 있다.
}
```



join - 쓰레드가 종료 될 때 까지 기다린다.

```java
Th2 th2 = new Th2();
th2.start();
th2.join();// th2 쓰레드가 수행을 끝낼때 까지 기다린다.
System.out.println("sum:"+th2.getSum());
```



#### Syncronized 동기화

여러쓰레드가 공유하고 있는 자원에 접근한다면 값의 변화에 동기화가 필요하다.

하나의 쓰레드가 공유자원의 사용을 하고 있다면 다른 쓰레드들은 앞선 쓰레드의 작업이 끝날때 가지 기다리게 된다.

```java
public synchronized void widthdraw(int m) throws Exception{	
    if(balance>= m)
        balance -=m;
    else
        wait();
    //wait 처리를 하게 되면, balance < m 을 만족할 때 까지 waiting pool 에서 일시정지상태로 기다리게 된다.
}
public void deposit(int m) throws Exception{
    if(m <=0) {
        throw new Exception();
    }
    balance += m;
    notify();
    //notify 를 통해 waiting 을 하고 있는 쓰레드들에게 신호를 줌으로서 Runnable 상태로 만들어 준다.
	}

```



## 자바의 I/O

###### 스트림 Stream

​	데이터를 운반하는데 사용되는 통로

File I/O , Network I/O 가 대표적, Thread 간의 Stream 도 존재한다.

1 byte 단위로 데이터를 전달한다. 

Filter - 큰 데이터를 다룰때는 buffer 를 사용해 큰 단위로 데이터를 전달하여 시간을 단축한다.



Java 는 기본적으로 2 byte 를 단위로 다루기 때문에 

InputStream :arrow_forward: Reader

OutputStream :arrow_forward: Writer

를 사용한다.

```java
FileInputStream fi = null;
	FileReader fr = null;
	BufferedReader br = null;
	try {
		fi = new FileInputStream("text.txt");
		int data =0 ;			
		while((data=fi.read())!= -1) { // -1 이면 문장의 끝
			char c = (char) data;
			System.out.println(c);
		}
		fr = new FileReader("text.txt");
		br = new BufferedReader(fr);
		String str ;
		while( (str = br.readLine()) != null) {
			System.out.println(str);
		}
		fr.close();
		br.close();
    }
    catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
    }
```

###### Pipe 이용하여 데이터 전달

inputThread.java

```java
public class InputThread extends Thread {
	PipedReader input = new PipedReader();
	BufferedReader br;
	public InputThread(String name) {
		super(name);
		input = new PipedReader();
	}

	public void run() {
		StringWriter sw = new StringWriter();
		br = new BufferedReader(input);
		StringBuffer sb = new StringBuffer();
		int data;
		String str;
		System.out.println("Ready");
		try {
			while ((str=br.readLine())!=null) { // input 이 있기 까지 기다린다.
				sb.append(str);
			}
			System.out.println("recived " + sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PipedReader getInput() {
		return input;
	}

	public void connect(PipedWriter output) {
		try {
			input.connect(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

```

outputThread.java

```java
public class OuputThread extends Thread {
	PipedWriter output = new PipedWriter();

	public OuputThread(String name) {
		super(name);
		output = new PipedWriter();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		try {
			String msg = sc.next();
			System.out.println(msg);
			output.write(msg);
			output.flush();
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PipedWriter getOutput() {
		return output;
	}

	public void connect(PipedReader input) {
		try {
			output.connect(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

```

main

```java
public class Main {
	public static void main(String[] args) {
		InputThread it = new InputThread("");
		OuputThread ot = new OuputThread("");
		it.connect(ot.getOutput());
		it.start();
		ot.start();
	}
}
```

Java의 Object 도 Stream을 통해서 전달이 가능하다.

```java
FileOutputStream fos = new FileOutputStream("user.dat");
BufferedOutputStream bos = new BufferedOutputStream(fos);
ObjectOutputStream oop = new ObjectOutputStream(bos);
User u = new User("id01", "pwd01", 30);
oop.writeObject(u);
oop.close();
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
FileInputStream fos = new FileInputStream("user.dat");
BufferedInputStream bos = new BufferedInputStream(fos);
ObjectInputStream oop = new ObjectInputStream(bos);		
User u = (User) oop.readObject();
System.out.println(u);
oop.close();
```

Stream을 통해서 전달하는 것을 원치않으면 transient 로 선언한다.

```java
public class User implements Serializable{
	private String id;
	transient private String pwd;
	private int age;
	public String getId() {
		return id;
	}
}
```

## Network

InetAddress - ip 주소를 알아내기 위해 사용.

Screen Scrapping

```java
public static void main(String[] args) throws Exception {
    URL url = new URL("http://70.12.60.90/test");
    URLConnection conn = url.openConnection();
    InputStream is =conn.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String data;
    StringWriter sw = new StringWriter();
    while((data = br.readLine())!=null) {
        sw.write(data);
        sw.write("\n");
    }
    System.out.println(sw.toString());
    sw.close();
}
```

File 또한 byte 단위로 읽어들인후 출력을 통해 다운로드 받을 수 있다.

```java
public static void main(String[] args) throws Exception {
    URL url = new URL("http://70.12.60.90/test/oracle.zip");
    InputStream is = url.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    FileOutputStream fo = new FileOutputStream("output.zip");
    BufferedOutputStream bos = new BufferedOutputStream(fo);
    int dat =0;
    BufferedInputStream br = new BufferedInputStream(is,1024);
    while((dat = br.read())!=-1) {
        bos.write(dat);
    }
    System.out.println("Finishhhh.....");
    br.close();
    bos.flush();
    bos.close();
}
```



url에 쿼리를 전달하고 값 받아오기

```java
String id ="zukgeDDa";
String pwd ="banga";
URL url = new URL("http://70.12.60.90/test/login.jsp?id="+id+"&pwd="+pwd);		 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("GET");
conn.setReadTimeout(10000);
InputStream a= conn.getInputStream();
InputStreamReader bs = new InputStreamReader(a);
BufferedReader br = new BufferedReader(bs);
if(conn.getResponseCode() ==HttpURLConnection.HTTP_OK) { // 정상연결
    String str;
    while((str=br.readLine())!=null)
        System.out.println(str);			
}
else {
    System.out.println("Err");
}
bs.close();
```

## Socket

프로세스 간의 통신을 위해 사용되는 endpoint.

#### 

### TCP / IP

TCP (Transmission Control Protocol) / IP (Internet Protocol)

- 이기종 시스템 간의 통신을 위한 표준 프로토콜의 집합

TCP 와 UDP

TCP

- 1대1 방식
- 연결 후 통신
- 신뢰성보장

UDP

- n 대 n 통신방식
- 비연결기반
- 신뢰성 없는 전송
- 전송속도가 빠르다.

```java
public class Server {
    int port;
    ServerSocket serverSocket;
    Socket socket;
    OutputStream out;
    OutputStreamWriter outW;
    BufferedWriter bw;
    public Server(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
    }
    public void startServer() throws IOException {
        System.out.println("Server Start..");
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("Server Ready..");
                socket = serverSocket.accept(); // 접속을 기다린다.
                System.out.println("Server Accepted.. " + socket.getInetAddress());
                out = socket.getOutputStream();
                outW = new OutputStreamWriter(out);
                bw = new BufferedWriter(outW);
                bw.write("wellcome to the paradise");
            } catch (IOException e) {
                throw e;
            } finally {
                if (bw != null)
                    bw.close();
                if (socket != null)
                    socket.close();
            }
        }
        System.out.println("Server Dead... ...");
    }
}
```

```java
public class Client {
    String ip;
    int port;
    ServerSocket serverSocket;
    Socket socket;
    InputStream in;
    InputStreamReader inR;
    BufferedReader br;
    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
    public void request() throws Exception {
        try {
            in = socket.getInputStream();
            inR = new InputStreamReader(in);
            br = new BufferedReader(inR);
            String str = br.readLine();
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                in.close();
            if (inR != null)
                inR.close();
            if (br != null)
                br.close();
        }
    }
    public void startClient() throws Exception {
        System.out.println("Client Start");
        try {
            socket = new Socket(ip, port);
            request();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null)
                socket.close();
        }
    }
}
```



