이름

전공

관심분야	

프로젝트

MVC

MVVM

크롤링





## Day01

GraphQL

sql과 같이 쿼리 언어다.

**웹 클라이언트**가 데이터를 서버로 부터 효율적으로 가져오는 것이 목적입니다.



클릭 -> 화면바꿔 -> 데이터 채워



response 의미

| 번대 | 의미                  |
| ---- | --------------------- |
| 200  | 정상                  |
| 300  | redirection           |
| 400  | Client Error (사용자) |
| 500  | Server Error (개발자) |

```python
import requests #주석 처리는 #으로 한다.
url = "http://ticket.melon.com/offer/ajax/offerList.json?offerPosType=MAIN_B_CO_2"
# 정상적인(브라우져를 통한) 방식 이 아닌 접근이기 때문에 406 에러가 뜬다.
# 한마디로 외부 접근을 막아논 것. 
header = {'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.70 Safari/537.36'}
# #브라우저의 접근이라고 말해주기 위해 User-Agent 속성을 추가해서 보내준다.
response = requests.get(url,headers=header)
print(response.text)
```



###### Notion - 정리하기 좋은 툴





## Day02

- 파이썬 딕셔너리
  - 딕셔너리?
  - 어떻게 쓰나 
  - JSON과의 차이
  - 활용해서 문제 풀기



#### Dictionary

​	Key - Value , 쌍으로 데이터를 저장하는 방식,

Java의 HashMap 과 같다. 

Key 값은 고유해야한다, 중복 되면 안된다 이말이다. o

```python
lunch_menu={
    "20층_식당" : {
        "A코스" : "돈까스",
        "B코스" : "육개장"        
    },
    "양자강":{
        "점심메뉴":"탕짬면",
        "특선메뉴":"군만두"
    },
    "대동집":{
        "밥안주":"비빔면",
        "술안주":"오돌뼈"
    }
}
print(lunch_menu)
print(lunch_menu["20층_식당"]["B코스"])
print(lunch_menu.get("20층_식당").get("A코스"))
lunch_menu["경성불백"] = {
    "한식":"불고기백반",
    "특식":"돈까스"
}
print(lunch_menu)
lunch_menu["양자강"] = "짜장면"
print(lunch_menu)
print("----------------")
#모든 Key , value 뽑아내기
keys = lunch_menu.keys()
vals = lunch_menu.values()
items = lunch_menu.items()
print(keys)
#for in 방식을 사용해 반복한다.
#공백 (tab) 을 통해 반복문임을 구분한다.

for key, value in items:    
    print(key)
    print(value)
# 한번에 key, value 를 뽑을 수 있다. 간편하다.
print("----------------")
```



#### Random

```python
#random.choice()    여러개 중에 한개
#random.sample()    여러개 중에 여러개
print(random.choice(list(keys)))
print(random.sample(list(keys),2))
```



#### 덕타이핑 duck Typing

꽥꽥 울고 뒤뚱뒤뚱 걸으면 오리다,

객체의 변수 및 메소드의 집합이 객체의 타입을 결정한다.

```python
print(random.choice(list(keys)))
```

#### 조건문

```python

if 조건:
	조건실행문
elif 조건:
	조건실행문2
else :
    나머지
```

#### 함수정의하기

```python
def func(param):
    print(param)
```



다음웹툰에서 정보 크롤링 하기

```python
import random
import requests
import json

def request_json_from_url(url):
    response = requests.get(url)
    data=response.json()
    return data

def parse_daum_webtopon_data(data):
    toons = []
    for toon in data["data"]:
        title = toon["title"]
        desc = toon["introduction"]
        genres = []
        for gs in toon["cartoon"]["genres"]:
            genres.append(gs["name"])
        artists = []
        for gs in toon["cartoon"]["artists"]:
            artists.append(gs["name"])
        img_url = toon["pcThumbnailImage"]["url"]
        tmp = {
            title :{
                'desc':desc,
                'genres':genres,
                'writer':artists,
                'img_url':img_url
            }
        }
        toons.append(tmp)
    return toons
day = [
    'mon','tue','wed','thu','fri','sat','sun'
]
dayWebtoon ={

}
for dd in day:
    url = f"http://webtoon.daum.net/data/pc/webtoon/list_serialized/{dd}"
    ## formating , 문자열 합치기
    data = request_json_from_url(url)    
    dayWebtoon[dd] = parse_daum_webtopon_data(data)
print(dayWebtoon)
```

##### Sleep

```python
import time
time.sleep(3)
```

##### flask

python을 이용하여 웹 요청을 처리할 수 있도록 해주는 , 서버를 구동시키게 해주는 프레임워크

경량화

```python
from flask import Flask , escape, request
# 기본으로 flask 의 port 는 5000번 이다.
app = Flask(__name__)
if __name__ == '__main__':
    app.run(debug=True)
    #debug mode - 서버를 재시작 하지 않아도 브라우저에서 새로고침만으로 갱신이 가능하다.
@app.route('/')
def index():
    return {'method': 'Hello'}

$env:FLASK_DEBUG="TRUE"
$env:FLASK_ENV="Development"
#위 명령어로 디버그 모드, 개발자모드로 환경설정을 해준다.

```

## Day3

- parameter
  - query string
  - path parameter
- html 파일로 view 만들기 (render template)
- Beautiful soup
  - 사이트 구조 분석 (html)
  - URL 구조(query string) 분석



```python
@app.route('/')
def index():          
    # request.args -> Dicktionary(Immutable)
    # 클라이언트로 부터 받은 파라미터를 저장하고 있다
    student = request.args.get('student')
    return student

## Spring 의 그것과 같이 해당 url로 접속시 화면을 연결 해 준다.
## /daum_webtoon/ 뒤에 오는 값을 day에 담아 사용한다.
@app.route('/daum_webtoon/<day>')
def daum_toon(day) :    
    url = f"http://webtoon.daum.net/data/pc/webtoon/list_serialized/{day}"
    ## formating , 문자열 합치기
    data = request_json_from_url(url)    
    dayWebtoon[day] = parse_daum_webtopon_data(data)
    return dayWebtoon

@app.route('/daum_webtoon')
def daum_toon_index():
    days = ['mon','tue','wed','thu','fri','sat','sun']
    msg = "alone"
    return render_template('daum_webtoon_list.html', **locals())
## **locals() 로 해당 html 에 지역 번수들을 전달해줄 수 있다.
## 만약 원하는 데이터만 전달해 주고 싶다면, (~~.html' , days = days , msg = msg) 로도 가능하다.
```

#### BeutifulSoup

html 속에서 원하는 정보들을 find , select 할 수 있다.

pip install beutifulsoup4



```python
from bs4 import BeautifulSoup
import requests
url = "http://www.saramin.co.kr/zf_user/jobs/list/job-category?cat_cd=404&panel_type=&search_optional_item=n&search_done=y&panel_count=y"
response = requests.get(url)
html = BeautifulSoup(response.text,'html.parser')
## 받아온 데이터를 파싱한다.
company_names = html.select('.company_name')
# company_name 클래스를 list 형태로 모두 가져온다

###############################################

html = BeautifulSoup(response.text,'html.parser')
 ## html 내 상위 클래스 안에 있는 것들에 대해 따로 처리가 가능하다.
company = html.select('.part_top')
for com in company:
    name = com.select_one('.company_name')
    rec = com.select_one('.recruit_name')
    cond  = com.select_one('.list_recruit_condition')
    print(f'{name.text} :: {rec.text} -{cond.text}')
 #################################################
    

## 회사 공고 상세보기 페이지에서 데이터 크롤링하기
company_list = html.select('ul.product_list li')
for com in company_list:
    company_info_url =f"http://www.saramin.co.kr{com.select_one('a')['href']}"
    idx = company_info_url.split('=')[-1]    
    company_info_url = 'http://www.saramin.co.kr/zf_user/jobs/relay/view-ajax'
    company_info_param = { 'rec_idx':idx }
    #post 방식을 사용하는 url 이기 때문에 parameter 들을 변수를 통해 넘겨준다.
    company_response = requests.post(company_info_url, params = company_info_param)
    #
    company_html = BeautifulSoup(company_response.text,'html.parser')
    company_title = company_html.select_one('.company_name').text
    print(company_title.strip())
    # strip() 함수를 통해 공백을 모두 없에준다.
    break
```



## Day4

CSRF Token ...?

​	보안. POST방식일때 사용





아이디어톤

- 새로운거 할려고 하지마
- 기존에 있던거 활용을 잘하자
  - api , 기존데이터를 가공, 이쁘게 하는 것 만으로도 서비스가 된다.





## REST API

``Representational State Transfer``

Interface , 약속

- URI는 정보의 자원을 표현해야 한다.
- 자원에 대한 행위는 HTTP Method (GET, POST, PUT, DELETE) 로 표현한다. 각 자원에 대한 행위가 다르다.
  - CRUD 를 했을 때 각각의 Method 하나로 표현이 가능 해야 한다. (매칭)
  - C - POST, R - GET , U - PUT / PATCH , D - DELETE
  - 같은 URI를 사용하더라도 Method 에 따라 행위가 달라질 수 있다.

ㅇ

#### Django

```shell
django-admin startproject [projectname]
# 프로젝트 만들기
python manage.py runserver 
# 서버 시작, 포트는 기본적으로 8000번을 사용한다.
python manage.py migrate
python manage.py startapp [appname]
```

urls.py - 모든 urlpatterns을 관리

url (-> domain을 ip로 치환, DNS ) -> requests -> route -> controller -> model -> controller -> View -> response -> Browser

setting.py - 



## Day05

Django 시작하기

- 프로젝트 만들기
- 프로젝트 vs 어플리케이션(app)
- MVC -> MVT
- Model View Controller -> Model View(Controller)Template(View)



시작하기

```shell
django-admin startproject [projectname]
cd [project]
python manage.py startapp [appname]
#django 에서 app 단위는 하나의 모델에 대한 모든 내용잉 담겨 있다.
#예를 들어 게시판을 만든다면, Post라는 app을 만들어 그안에서 모든 처리를 한다.
```

project

- settings.py
  - INSTALLED_APPS

    - 해당 프로젝트에서 실행될 app들을 선언해준다.

    - ```python
      INSTALLED_APPS = [
          'lotto',
          ....
      ]
      ```

- urls.py

  - request가 들어온 url을 views의 method와 연결해주기 위해 app의 views를 import 한다.

    - ```python
      from lotto import views
      #lotto app 의 view를 가져온다.
      from lotto import views as lotto_views
      from ascii import views as ascii_views
      ## 만약 여러 app 을 사용 한다면 views 에 alias 를 줄수도 있다.
      ```

  - urlpatterns

    - ```python
      urlpatterns = [
          path('admin/', admin.site.urls),
          path('lotto/',lotto_views.lotto),
          path('winning/',lotto_views.winning),    
      ]
      ```

app

- views.py

  - url 을 매핑받고 수행할 method를 정의한다.

  - ```python
    # 매핑 받을 method 는 항상 request를 parameter로 받아야 한다.
    def lotto(request):
        return render(request , 'lotto.html', {'lotto':lotto} )
    # 변수를 render 의 3번째 parameter 로 전해줄 수 있다.
    ```

project 안의 templates 폴더가 파일의 기본 directory 이다.

templates

- winning.html

  - ```html
    <body>    
        <h1>당신의 숫자</h1>
        <h3>
            <!-- method 에서 건내준 변수를 사용할때-->
        {% for num in picked %}
            {{ num }}
        {% endfor %}
        </h3>
        <h1>당첨 숫자</h1>
        <h3>
            {% for n in balls %}
             {{n}}
             {% endfor %}
             + {{bonus}} <br>
        </h3>
        맞은 갯수: {{win_cnt}} <br>
        {% for n in winning_list %}
            {{n}}
        {% endfor %}    
        <h2>
            당첨금 ::{{fst}}
        </h2>
    </body>
    ```

  - 



## Day6

[kakaoDeveloper](https://developers.kakao.com/docs/restapi/)



api 문서 볼때 주의할 점

- 요청방식
- 요청을 보내야 할 주소 (End-point)
- 필수적인 Parameter

```python
json.loads(response.text)
#String daa를 json으로(dictionary로) 강제 변환
```



## Day7

네이버 datalab api 쓰기

class

python 에서의 c;ass

```python
# class 의 선언

class Human:
    ## 변수선언
    name = 'name'
    age = 'age'    
    ## 함수 선언
    def say_hello(self): #parameter에는 self가 기본으로 들어간다.         print("hiroo")
    def walk(self,para) : # 다른 변수도 parameter에 넣을 수 있다.
        print("i'm walking" + para)
    
```

#### ORM

Object-Relational Mapping

간단하게 python 코드를 통해 DB의 table과 row를 조작할 수 있다.

table에 있는 row를 python 객체처럼 사용 할 수 있다.

model.py

```python
class Board(models.Model):
    title = models.CharField(max_length=30)s
    content = models.TextField()
    created_by = models.CharField(max_length=10 , null=True)
    # column 의 뼈대를 생성 한다.
```



```shell
python manage.py makemigrations
# models.py의 내용을 바탕으로테이블의 구조를 만드는 파일을 작성한다.
# migration 파일을 만들어 준다. ex)0001_initial.py
python manage.py migrate
# migration 파일을 토대로 db 구조를 만들어 준다.

```

###### python shell 명령어

python manage.py shell

```shell
from boards.models import Board
b1 = Board()
b1.titel='제목'
b1.save()
# db에 저장한다
# 이때 db는 기본적으로 [project]/db.sqlite3 파일이다.
b_all = Board.objects.all()
#모든 오브젝트들 배열로 리턴
b2 =Board.objects.filter(title='제목').first()
# 원하는 row 검색, 배열로 리턴한다.
```



save() 하기 전엔 table에 저장하지 않기 때문에 id를 갖지 않고,

save() 이후엔 table에 저장을 하면서, table의 해당 row를 가리키게 되고 이때 id를 갖게 된다.

해당 row를 가리키고 있기 때문에 정보를 변경하고 save() 를 하게 되면 UPDATE와 같이 덮어씌우기가 된다.

```shell
>>> b1 = Board()
>>> b1.title = '테스트'
>>> b1.save()
>>> b_all = Board.objects.all()
>>> for tmp in b_all:
...     print(tmp.title)
...
지금 먹으로 갑니다
롤리폴리
테스트
>>> b1.id
3
>>> b1.title = '빢빢'
>>> b1.save()
>>> b_all = Board.objects.all()
>>> for tmp in b_all:
...     print(tmp.title)
...
지금 먹으로 갑니다
롤리폴리
빢빢
>>> b1.id
3
>>> b2.id
2
>>> b3.id
1
>>> b1 = Board()
>>> b1.id
>>>
```



## Day8

```python
#django 에서도 path-para 방식을 사용할 수 있다.
#views.py
def show(request, id):
    return
#urls.py
urlpatterns = [
	path('boards/<id>/',boards_views.show)
]
```

###### block content 를 사용한 html 간소화

중복되는 값들 (설정 등등) 을 base.html 과 같이 한 곳에 저장하고 다른 페이지에서는 내용만 작성한다.

index.html

```html
{% extends 'base.html' %} 
<!--base.html 을 먼저 읽어 오고, base.html 에 있는 block content안에 내용을 넣는다.-->
{% block content %}
	<!-- 내용 입력-->
{% endblock %}
```

base.html

```html
<head>~~~</head>
<div class="container">
	{% block content %}
	{% endblock %}
</div>
<script>~~~</script>
```

URL 분리하기

기존에는 urls.py에 모든 주소를 명시했지만 CRUD를 위해서 필요한 페이지가 많기 때문에 분명히 하기 위해 각각의 App 마다 url.py를 만들어 관리한다.



urls.py

```python
from django.urls import path , include #include를 import

urlpatterns = [
    path('admin/', admin.site.urls),
    path('boards/',include('boards.urls'))
    #boards.urls 파일에 정의된 path들을 사용한다.
    #app 디렉토리 안에 새로운 urls.py 파일을 만들어 주었다.
]
```

boards/urls.py

```python
from django.urls import path
from . import views as boards_views
urlpatterns = [
    path('',boards_views.index),
    path('new/',boards_views.new),
    path('create/',boards_views.create),
    path('<int:id>/',boards_views.show),
    path('<int:id>/update',boards_views.update),
   	##path-para 방식 중 값의 type을 정해서 넘겨 줄 수 있다.
]
```

boards/views.py

```python
def update(request, id): ##넘겨준 값을 parameter로 받는다
    board = Boards.objects.get(id=id) ##Boards table 에서 하나의 row만을 가리키기    
    title = request.GET['title']
    content = request.GET['contents']
    board.title = title
    board.contents =content    
    board.save()
    return redirect(f'/boards/{id}')
```


#### tip
VSCODE에서 Git 활용하기

## DAY9

- pip install pylint
- pip install pylint-django
- 컴퓨터 속성 - 고급시스템설정 - 고급 - 환경변수 - PATH (python 녀석들만)복사
- VS code ctl+p ``>user settings`` 의 python:Python Path 에 붙여넣기

C -> new , create

R ->index, show

U -> edit , update

D -> destroy

##### URL namespace

- 각각의 url에 ``별명``을 지어줘서 html 파일에서 사용하는 링크를 추가적으로 바꾸지 않고, ``urls.py``에서만 수정하면 html 파일에서도 링크 수정이 반영되게끔 함

urls.py

```python
app_name = 'articles'
#
urlpatterns = [
    path('', views.index,name="index"),
    path('<int:id>/',views.show,name="show"),
	path('edit/<int:id>',views.edit,name="edit"),
    #name 을 통해 별명을 지어줄 수 있다.
]

```

index.html

```html
<tr herf="{% url 'show' tmp.id %}"></tr>
<a href="{% url 'articles:edit' article.id %}" class="btn btn-info" >수정</a>
<!-- {% url '[name]' } 을 통해 url의 별명에 접근할 수 있다.-->
<!-- {% url '[name]' parameter} 를 통해 인자를 전달할 수 있다.--> 
```



##### RESTful api

| 역할    | Request Method | End-point             | Views(function) |             |
| ------- | -------------- | --------------------- | --------------- | ----------- |
| Create  | GET            | /articles/new/        | new             | 새글 form   |
| Create  | POST           | /articles/new/        | new(create)     | 새글 작성   |
| Read    | GET            | /articles/<id>/       | show            | 글 하나     |
| Read    | GET            | /articles/            | index           | 전체 리스트 |
| Update  | GET            | /articles/<id>/edit/  | edit            | 수정 form   |
| Updtate | POST           | /articles/<id>/edit/  | edit            | 수정 반영   |
| Delete  | POST(DELETE)   | /articles/<id>delete/ | delete          | 삭제        |

models.py

```python
class Articles:
    created_at = models.DateTimeField(auto_now_add=True , null=True)
    #날짜를 속성으로 할 수  있다.
    #auto_now_add=True 는 
	def datetime_to_str(self):
        return self.created_at.strftime("%Y-%m-%d")
#함수를 만들고 이를 html 에서도 실행 시킬 수 있다.
```

```html
<td>{{tmp.datetime_to_str}}</td>
```

##### admin

python manage.py createsuperuser

​	  ,.,.,..

⎝⎛•‿•⎞⎠



## Day10

CSRF

post 방식으로 값을 전달하기 위해서 csrf 토큰이 필요하다

```html
<form>
    <input type="hidden" name="csrfmiddlewaretoken" value="{{csrf_token}}">
</form>
```

a 태그는 get 방식으로의 요청 밖에 할 수 없다.



## Day11

###### foreignkey

models.py

```python
class Article(models.Model):
    contents = models.TextField()
    create_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class Comment(models.Model):
    contents = models.TextField()
    create_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    target = models.ForeignKey(Article,on_delete=models.CASCADE)
    #Article를 참조하고, CASCADE로 설정하여 함께 삭제하게 한다.
    #자동으로 db 에는 target_id 가 생긴다
```



###### 비동기

특정작업 요청을 보내고 다른작업을 하다가 요청을 보낸 작업의 종료알림 (callback)만 받는다.



parameter를 여려개 보내 줄 수있다.

urls.py

```python
path('<int:article_id>/<int:type>/delete/',article_views.delete,name="delete"),
```

html

```html
<a href="{% url 'delete' article.id 2 %}" > 삭제</a>
```

## Day13

- Static file

  - ``개발환경`` vs 배포환경
    - 개발환경에서는 app 에서 관리
    - setting.py 의 최하단에 STATIC_URL = '/static/' 으로 기본경로를 설정한다.
    - 

- 이미지 업로드

  ```html
  <form enctype="multipart/form-data" ></form>
  ```

  form 태그에 enctype="multipart/form-data" 를 추가 해줘야 파일전송이 가능하다.

  ```python
  request.FILES["images"]
  ```

  setting.py 에 추가,  파일을 저장할 경로를 지정한다.

  ```python
  MEDIA_ROOT = os.path.join(BASE_DIR, 'media')
  #BASE_DIR 은 기본적으로 project 디렉토리를 의미한다.
  #projcet/media 디렉토리를 저장할 경로로 설정한다는 의미
  MEDIA_URL = '/media/'
  #MEDIA_ROOT 의 별명을 주어준것이다.
  -
  ```

  project.models.py 에 추가

  ```python
  from django.conf import settings
  from django.conf.urls.static import static
  urlpatterns+= static(settings.MEDIA_URL,document_root=settings.MEDIA_ROOT)
  ```

  - 모델 하나에 직접 입력

  - 이미지 리사이징

    - models.py

    - ```python
      from imagekit.models import ImageSpecField, ProcessedImageField
      from imagekit.processors import ResizeToFill
      image_resized = ProcessedImageField(
             # source='image',
              upload_to='insta/images',
              processors=[ResizeToFill(200,200)],
              format='JPEG',
              options={'quality': 90}
      )
      ```

    - image_resized.url 로 경로에 접근 할 수 있다.

  - 이미지 썸네일
    - 

    ```python
    from imagekit.processors import Thumbnail
    
    image_thumbnail = ImageSpecField(
            source='image',
            processors=[Thumbnail(200,200)],
            format='JPEG',
            options={ 'quality':100 }
    )
    #자동으로 MEDIA_ROOT/CACHE 에 원본 이미지의 썸네일을 생성한다.
    ```

    - html

      ```html
       <img src="{{tmp.image_thumbnail.url}}" class="card-img-top " alt="Blueming.jpg">
      ```

      

- Multiple 이미지 업로드

  - 하나의 Article에 여러 이미지 업로드하기

- JS기본

  - 동적인 페이지 만들기
  - JQuery -> JS프레임워크(X) JS라이브러리(O)



## Day14

jsTest	 ``camel case``

js_test	 ``snake case``



###### JS

```javascript
console.log("로그");
alert("얼럿");
promtpt("프롬프트");
confirm("컨풞");

document.getElementById('id');
document.getElementsByClassName('class'); //배열을 리턴한다.
documnet.querySelector('.classname');
documnet.querySelectorAll('.classname'); //
document.getElementsByTagName('p'); //

```

```javascript
var pList2 = document.querySelectorAll('p'); 
// forEach 함수사용을 위해서는 NodeList를 return 하는 querySelecetor 를 써야한다.
console.log(pList2);
pList2.forEach(function (element) {                
    element.addEventListener('click', function () {
        //element.setAttribute('class', 'p-tag');
        element.classList.toggle('bgred')
        // if(confirm("wanna delete this line?")){
        //     element.setAttribute('style', 'display:none;');
        // }
    })
})

```

event로 li 추가하기

```javascript
var btn = document.getElementById('submitComment')
btn.addEventListener('click',function(){
    txt = document.getElementById('commentForm')
    target = document.querySelector('.list-group')                
    var appendingTag= document.createElement('li');
    appendingTag.classList.add('list-group-item')
    appendingTag.innerText=txt.value
    console.dir(appendingTag);
    target.prepend(appendingTag)
    txt.value=''
});
```

###### JQuery

```javascript
$(document).on('ready',function(){});
$(function(){});
// 두개는 같은 의미이다.

$(function () {
    $('#submitComment').click(function(){
        var position = $('ul.list-group');
        var input= $('#commentForm').val();
        $('#commentForm').val('')
        var element = `<li class="list-group-item" id="cmt-1">
${input}
<span class="float-right" >
<button type="button" class="btn btn-warning">수정</button>
<button type="button" class="btn btn-danger delete-comment" value="1">삭제</button>
</span>
</li>`
        //`` backtip ~룸메, 줄바꿈을 포함한 텍스트를 string으로 묶을 수 있다.
        position.prepend(element)
    });
    $(document).on('click', '.delete-comment', function () {
        //document에 존재하는 모든 클래스에 onclick 리스너를 달아준다.
        var comm_id = $(this).attr('value')
        $(this).parents('.list-group-item').remove();
        id = '#cmt-'+comm_id
        // $(id).remove()

    });

});
```

## Day15

###### JQuery

```javascript
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
```



###### AJAX (Asynchronous Javascript And XML)

- 비동기JS & XML

- Callback

- ```javascript
    <script>
    $(function(){
        $.ajax({
            url: '어느 주소로 요청을 보낼지',
            method: '어떤 request method로 보낼지',
            data: {
                key: '어떤 형태로 보낼지'
            },
            success: function(data) {
                '요청이 성공적으로 완료됐을 때'
            },
            error: function(data) {
                '요청이 정상적으로 완료되지 않았을 때'
            }
        })
    })
    </script>
  ```

- ```javascript
   // 삭제 버튼을 눌렀을 때
  $(document).on('click', '.deleteBoard', function () {
      // 해당 줄(list)을 하나 삭제해야함
      var id = $(this).data('value'); // data-value="{{board.id}}"
      // 실제로 DB에서 삭제하기.
      $.ajax({
          url: '{% url "delete_boards" %}',
          method: 'POST',
          data: {
              board_id: id,
              csrfmiddlewaretoken: '{{csrf_token}}' // post로 보내주기 때문에 필요해
          },
          success: function (data) {
              alert("삭제 성공");
              $('#board-' + data.board_id).hide();
          },
          error: function (data) {
              alert("삭제 실패");
          }
      })
      // $('#board-' + id).hide(); // 눈에만 안보이게 하는것. 숨긴다. 새로고침하면 다시 생김.
  })
  ```

- ```javascript
  $('.target').data('Attribute_name')
  ```

- - html 태그의 data- 로 시작하는 속성의 값을 가져올 수 있다.

```python
def delete_boards(request):
    if request.method == "POST":
        id = request.POST["board_id"]
        board = Board.objects.get(id=id)
        board.delete()
        context = {
            'board_id':id
        }
        # 삭제를 하면 network 탭에 delete가 오고 preview로 보면 json형식으로 온것을 확인할 수 있음.
        return HttpResponse(json.dumps(context), content_type="appication/json")
   	#json 형식으로 return 해 줄 수 있다.
```





Server 에서 render() 를 return 하고, ajax 의 success() 에서 이를 받아 div에 append를 해준다면

화면내에 다른 화면을 붙여넣기가 가능하다.

server

```python
def submit_boards(request):
    if request.method == "POST":
        contents = request.POST["board"]
        board = Board.objects.create(contents=contents)
        context = {
            'board': board
        }
        return render(request, 'empty.html', context)
```

ajax

```javascript
$.ajax({
    url: '{% url "submit_boards" %}',
    method: 'POST',
    data: {
        board: board,
        csrfmiddlewaretoken: '{{csrf_token}}'
    },
    success: function(data) {
        $('.list-group').prepend(data);
    },
    error: function(data) {
        alert("실패!")
    }
})
```

## Day16

```javascript
 $(document).on('submit','#commentForm', function (event) { // e : event
     // 기존 이벤트를 삭제 해주어야 한다
     event.preventDefault();
     id = $(this).find('input.articleId').val() //find 로 CSS selector 를 사용하여 안에 있는 녀석들 중 하나를 고를수 있다.
     var data = $(this).serialize(); // 하위의 모든 값들을 가져올 수 있다!!!
     $.ajax({
            url: '{% url "comments" %}',
            method: 'POST',
            data: data, // 로 모든 값들을 한번에 보내 줄 수 있다... ㅎㄷㄷ
         .......
     })
     var newDiv = `<li class="list-group-item">${data.comment_id}</li>`
     //`` 안에서 ${variable} 로 변수에 접근 할 수 있다.
     
 })
```

#### USER

기본적으로 장고에서는 로그인, 로그아웃, 회원가입 등의 모델이 구현되어있기 때문에 새로 만들 필요가 없다.

python manage.py createsuperuser





###### cookie , session

http request 의 무상태성(statless) 을 해결하기 위해 구상된 개념.

정보 저장의 주체에 차이가 있다.

- Cookie - 내 Browser
  - Browser에서 실제 정보 값들을 물고 있다.
  - Browser 마다 고유하다.
  - 쉽게 접근 할 수 있기 때문에 보안에 취약하다.
  - 브라우저가 종료 되어도 날아가지 않는다.
- Session - Server Computer
  - 메모리 , DB 등 에 저장하고, 내 컴퓨터는 정보의 위치만 알고 있다.
  - Browser를 종료하면 정보가 날아간다.

views.py

```python
from django.contrib.auth.models import User
from django.contrib.auth.forms import UserCreationForm , AuthenticationForm
from django.contrib.auth import login as auth_login 
from django.contrib.auth import logout as auth_logout

# Create your views here.
def login(request):
    if request.method == "POST":
        form = AuthenticationForm(request, request.POST)
        ## html의 form 에서는 반드시 email type 의 name="username"과
        ## password type 의 name="password" 가 필요하다
        if form.is_valid():            
            auth_login(request , form.get_user()) #로그인
            return redirect('/insta/')
        else:
            return render(request, 'login.html')
    else :
        if request.user.is_authenticated: # 이미 로그인 되어 있다면
            return redirect('/insta/')
        else:            
            return render(request,'login.html')
def logout(request):
    auth_logout(request)
    return redirect('/insta')
def signup(request):
    if request.method == "POST":
        form = UserCreationForm(request.POST)
        ## html의 form 에서는 반드시 email type 의 name="username"과
        ## password type 의 name="password1" ,name="password2" 가 필요하다
        if form.is_valid():
            print(form.is_valid)
            print(form.is_valid())
            user = form.save() #회원가입
            auth_login(request , user) #로그인
            return redirect('/insta/')
        else:
            return render(request,'signup.html')
    else:
        if request.user.is_authenticated:
            return redirect('/insta/')
        else:                              
            return render(request,'signup.html')
```

base.html

```html
{% if user.is_authenticated %} <!-- user.is_authenticated 를 통해 유저가 로그인을 했는지 확인 할 수 있다.-->
        <a class="btn btn-outline-primary" href="/accounts/logout">{{user.username}}</a>
{% else %}
        <a class="btn btn-outline-primary" href="/accounts/signup">Sign up</a>
{% endif %}
```



## Day 17

db와 AUTH_USER 연결하기

models.py

```python
class Article:
	user = models.ForeignKey(settings.AUTH_USER_MODEL , on_delete=models.CASCADE)
```

views.py

```python
if request.user.is_authenticated:
    art = Article()
    art.contents = request.POST["contents"]
    art.user_id = request.user.id 
    # request.user.id 로 간단하게 로그인한 user의 id에 접근 할 수 있다.
    ...
```

###### 다 대 다 테이블

``좋아요``  기능

```python
class Article:
	user_likes = models.ManyToManyField(settings.AUTH_USER_MODEL, related_name="article_likes") 
# 새로운 테이블이 생성 된다.
# Article 에서는 .user_like로 접근하고, user 에서는 .article_likes 로 접근한다.
```

views.py

```python
def likes(request):
    if request.user.is_authenticated and request.method =="POST":        
        article_id =request.POST["article_id"]
        article = Article.objects.get(id=article_id)
        if request.user in article.user_likes.all():
            # in
            article.user_likes.remove(request.user)
        else:
            article.user_likes.add(request.user)
        likes_count = len(article.user_likes.all())
        context={
            'cnt':likes_count
        }
        return HttpResponse(json.dumps(context),status=200,content_type='application/json')
    else:
        return HttpResponse('',status=403)
```





- Pusher (실시간 기능) - 위부 API



## Day18

- 회원가입 -> 유저에게 접근할 수 있는 범위를 지정해줌
- M:N Field - ManyToManyField



##### Pusher

pip install pusher

###### setting	

```html
<script src="https://js.pusher.com/5.0/pusher.min.js"></script>
```

javascript

```javascript
	Pusher.logToConsole = true; //pusher의 신호가 올때 마다 log 기록 
    var pusher = new Pusher('###SECRET KEY###', {
        cluster: 'ap3',
        forceTLS: true
    });
    var channel = pusher.subscribe('{{room.code}}');
    // 해당 채널을  구독,
    channel.bind('chat', function (data) {
        //'chat ' 이벤트 발생시 함수 작동
        var contents = "";
        $('.chat-messages').append(`<p>${data.user} : ${data.message}<p>`)
    });
```



python

```python
context={
    'user':request.user.username,
    'message':message.contents,        
}
pusher_client.trigger(room.code, 'chat', json.dumps(context))
```



## Seson 2



- 프로젝트의 환경을 외부와 독립적이게 설정 하는 것이 좋다.
  - ex) 프로젝트 내에 library 등을 갖고 있고, 외부에서는 관여하지 못하게

```shell
python -m venv venv
## python 의 기본 path 에서 현재 directory 로 복사 한다.
source venv/Scripts/activate
## shell의 연결을 global 에서 venv 폴더로 옮기겠다.
pip freeze > requirements.txt
## 버전 명시를 담은 파일 생성

git rm -r --cached board/
## git 에 올라가 있는 폴더를 내린다.

```



```shell
pip install django_extensions
pip install ipython
```

###### vscode-extensions

- Django
- SQLite
- vscode-icons



404 표현 해주기 

```python
from django.shortcuts import render , get_object_or_404
def article_detail(request , article_id):    
    article= get_object_or_404(Article, id= article_id)
    context={
        'article':article
    }
    return render(request, 'board/article_detail.html',context)
```

## Day02

###### Templates 경로 지정

settings.py

```python
#line 58 TEMPLATES
        'DIRS': [ os.path.join(BASE_DIR,'templates') ], 
        # template 를 찾을 때 추가로 검색할 경로를 지정해 준다.
        # default : Installed_Apps 의 templates 는 자동으로 지정 되어 있다.

```



###### django Forms 사용, form 개발 간략화

(django- bootstrap4 사용)

```shell
pip install django-bootstrap4
```

settings.py

```python
    INSTALLED_APPS = [
        ...
    'bootstrap4', # 추가 
        ...
    ]

```

```django
{% extends 'base.html' %}
{% load bootstrap4 %}
{% block content %}
<h1>New article!@</h1>
<form action="{% url 'board:new_article' %}" method="post">
    {% csrf_token %}
    {% bootstrap_form form %}    
    <input type="submit" value="submit">
</form>
{% endblock content %}
```

forms.py

```python
from django import forms
# from django.db import model 와 유사
from .models import Article, Comment

class ArticleForm(forms.ModelForm):
    # html 에서 1차적으로 막아주고, 서버 단 작업에서도 is_valis() 를 이용해서 이를 막아 줄 수 있다.
    title = forms.CharField(min_length=2,strip=True)
    email = forms.EmailField()
    keword = forms.CharField(min_length=1,max_length=10)
    class Meta:
        model = Article
        fields = '__all__' # model 에 정의한 field들을 __all__ 이라고 쓴다.
       #fields = ('title','content') tuple or list 로 쓰고자 하는 field만 정의할 수 있다.
        exclude = ['datetime']
        #제외 하고자 하는 field를 설정할수 있다.
```



views.py

```python
from .forms import ArticleForm
def new_article(request):
    if request.method == "POST":
        form = ArticleForm(request.POST)        
        if form.is_valid() :
            article = form.save()
            return redirect('board:article_detail',article.id)
    else:
        form = ArticleForm()
    context={
        'form':form
    }
    return render(request , 'board/article_form.html', context)

def edit_article(request, article_id):
    article = get_object_or_404(Article, id= article_id)
    ##
    if request.method == "POST":
        form = ArticleForm(request.POST , instance=article)
        ## instance = article로 받은 데이터를 article로 지정한다.
        if form.is_valid() :
            article = form.save()
            return redirect('board:article_detail',article.id)
    else:
        form = ArticleForm(instance=article)
    context={ 'form':form }
    return render(request , 'board/article_form.html', context)
```



###### 값이 비어 있을 때, blank / null

- blank= True 
  - is_valid() 에서는 통과할 수 있게 된다. 하지만 null=false 하면 DB 단에 저장할때 error가 발생할 것이다.
  - 따라서, null=false 인데 blank=True 라면 의미 없는 옵션이 되어버린다.
- null=True
  - DB단에 null 값을 수용하겠다.

charField 와 textField 는 빈값도 값으로 처리하기 때문에 blank=True 옵션만 주어도 not null valid error 가 발생하지 않는다.





만약 form 에 action 이 정해지지 않았다면 내용을 현재 url로, method 방식으로 보내게 된다.





## DAY03



signup / login / logout



AbstactUser





```python
rqeust.GET.get('key') # 'key'가 없으면 None 을 return
rqeust.GET['key'] #'key' 가 없으면 error
```



## DAY04

배포 

heroku cli 설치.



push 만으로 heroku에 배포를 할 수 있다.

heroku 에 git commit 기준으로 배포가 된다.



settings.py 

```python
#23 line SECRET_KEY 배포단계에서는 숨겨놔야 한다.
#28
ALLOWED_HOSTS = ['127.0.0.1',' ']
#127
STATIC_ROOT = os.path.join(BASE_DIR, 'static'),
#129
import django_heroku
django_heroku.settings(locals())

```

project 폴더에 Procfile 파일 생성

```
web: gunicorn hotplay.wsgi --log-file -
```

어떤 웹 서버를 사용할지를 설정하는 파일이다. urls.py 를 연결하는 (web server gate interface 를 ) 사용 하겠다.



project 폴더에 runtime.txt 생성

```
python-3.8.0
```

pip freeze > requirements.txt 로 기록.

```shell
heroku login
heroku create hotplay
#url 한개와 git remote repository 받기
git remote -v #연결 확인
heroku config:set DEBUG=False
```

https://devcenter.heroku.com/articles/clock-processes-python

urls.py 에 있는 녀석 frequently 를 cron job 으로, 외부로 넘긴다.



```shell
python manage.py dumpdata > hotplay/fixtures/data.json
python manage.py loaddata data.json
```

##https://hotplay.herokuapp.com/



## Day X

github action 을 이용한 주기적 요청

redis 는 메모리에 DB를 올린다 말도 안되게 빠르다.

게임 랭크모드 등과 같이 실시간으로 변동이 되야 하는 경우에 사용한다.

스키마 없이, NoSQL 식

휘발성인 메모리에 저장하기 때문에 프로세스가 꺼지면 데이터가 모두 날라간다.