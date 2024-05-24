# 게시판 프로젝트 [미니]
<hr>
<br/>

## 프로젝트 요구사항
### 글 등록
- [x] 이름, 제목, 암호, 본문을 입력
- [x] 등록일, ID는 자동으로 저장
- [x] 기능
    - [x] 특정 게시글을 쓰기위한 폼을 제공합니다.
    - [x] 사용자는 이름, 제목, 내용, 암호를 입력하고, 확인 버튼을 클릭하여 등록을 요청 합니다.
    - [x] 모든 내용이 잘 입력되어 있을 경우 /write 로 요청을 보내 등록 처리후 /list 로 리다이렉트됩니다.
        - [x] 밸리데이션 처리하기


### 글 목록 보기
- [x] 최신 글부터 보여짐
- [x] ID, 제목, 이름, 등록일(YYYY/MM/DD) 형식으로 목록이 보여짐
- [x] 페이징 처리 필요
- [x] 기능
    - [x] 게시글 목록을 페이지별로 보여줍니다.
    - [x] page 파라미터가 없으면 기본적으로 1페이지를 보여줍니다.
    - [x] 각 페이지는 최신 글부터 보여지며, 페이징 처리가 적용되어 있습니다.
    - [x] 하단에는 페이지 네비게이터가 있어 다른 페이지로 쉽게 이동할 수 있습니다.
    - [x] 각 게시글은 ID, 제목, 이름, 등록일(YYYY/MM/DD 형식)로 목록이 구성됩니다.


### 글 상세 조회
- [x] 암호는 보여지면 안됨
- [x] 글 등록일은 YYYY/MM/DD hh24:mi 형식으로 보여짐
- [x] 기능
    - [x] 특정 게시글의 상세 내용을 보여줍니다.
    - [x] 삭제와 수정 링크를 제공하여 해당 기능을 수행할 수 있는 페이지로 이동할 수 있습니다.
    - [x] 게시글의 등록일은 YYYY/MM/DD hh24:mi 형식으로 표시됩니다.
    - [x] 게시글의 암호는 보여지지 않습니다.


### 수정
- [x] 이름, 제목, 본문을 수정
- [x] 암호는 글 등록시 입력했던 암호를 입력해야함
- [x] 수정일은 자동으로 저장
- [x] 기능
    - [x] 특정 게시글을 수정하기 위한 폼을 제공합니다.
    - [x] 이름, 제목, 본문, 암호 필드를 포함하며, 사용자는 이를 수정할 수 있습니다.
    - [x] 확인 버튼을 클릭하면 /update 로 수정 요청을 보내고, 수정이 완료되면 해당게시글의 상세 페이지( /view?id=아이디 )로 리다이렉트됩니다.


### 삭제
- [x] 암호는 글 등록시 입력했던 암호를 입력해야함
- [x] 기능
    - [x] 특정 게시글을 삭제하기 위한 폼을 제공합니다.
    - [x] 사용자는 암호를 입력하고, 확인 버튼을 클릭하여 삭제를 요청합니다.
    - [x] 올바른 암호 입력시, /delete로 요청을 보내 삭제처리 후 /list로 리다이렉트 됩니다.

<br/>

## 결과물
### 글 목록 보기
![img.png](img.png)

### 글 상세 조회
![img_1.png](img_1.png)

### 글 등록
![img_2.png](img_2.png)

### 글 수정
![img_3.png](img_3.png)

### 글 삭제
![img_4.png](img_4.png)