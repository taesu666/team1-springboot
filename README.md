# 안녕하세요 반갑습니당
git 과 Github 실습하기
1. 준비물

본 블로그의 실습은 git이 설치된 로컬환경과 Github 계정이 필요합니다. 준비물이 필요하신 분은 아래 링크를 참고해주세요.
Git 설치

Github 계정 생성

2. git 버전 확인

먼저, git이 올바르게 설치되었는지 확인해보겠습니다. 터미널에서 다음 명령어를 실행하세요:
git --version

결과로 설치된 깃의 버전이 출력됩니다.



3. 로컬에 Github 계정 정보 등록하기

다음 명령어를 사용하여 로컬 깃에 깃헙 계정 정보를 등록합니다:
git config --global user.name "Your Username"
git config --global user.email "your@email.com"

git config --global user.name NamcheolHer
git config --global user.email nc.her@modulabs.co.kr

저는 username 이 ‘NamcheolHer’ 이고 email 이 ‘nc.her@modulabs.co.kr’ 입니다. 아래와 같이 진행하여습니다.
4. git 설정 정보 확인
git config -l 명령어를 사용하여 등록된 정보를 확인할 수 있습니다:
git config -l


5. 로컬 저장소 생성

저는 기존의 aiffel 이라는 디렉토리가 있습니다. aiffel 디렉토리 내에 workplace 라는 이름으로 디렉토리를 생성하겠습니다. 그리고 workplace 디렉토리 내에 readme.md 파일을 만들어 주겠습니다.
aiffel 디렉토리로 이동합니다.
workplace 디렉토리를 생성합니다.
workplace 디렉토리 내에 readme.md 파일을 생성합니다.
cd aiffel
mkdir workplace
cd workplace

여기서 cd 와 mkdir 은 리눅스 기초 명령어 입니다. cd 는 change directory 로 원하는 위치의 디렉토리로 이동합니다. mkdir은 make directory 로 새로운 디렉토리를 만드는 명령어입니다. 이외에도 다양한 명령어들이 있습니다. 더 많은 명령어가 궁금하시면 ‘리눅스 기본 명령어’ 로 검색해보시길 추천드립니다. 이번 블로그에서는 자세하게 다루지 않겠습니다.
6. git 초기화 및 확인
workplace 디렉토리에서 git init 명령어를 사용하여 깃 저장소를 초기화합니다:
git init


git init을 하면, 해당 디렉토리를 git 으로 관리할거야! 가 됩니다. 따라서 git의 버전 관리에 필요한 모든 정보를 저장하기 위해 .git 이라는 디렉토리가 함께 생성됩니다.

ls -a 명령어를 사용하여 .git 디렉토리가 생성되었는지 확인합니다:
ls -a


7. 
readme.md

 파일 생성하기
readme.md 파일에 "# first-repository"를 작성합니다. [#]을 통해 마크다운 헤딩1 기호를 붙였습니다. 현재 cli에서는 적용되지 않지만 마지막 단계에서 Github 원격 저장소에 push 하면 헤딩1 스타일이 적용될겁니다.
echo "# first-repository" >> readme.md

echo 를 통해 readme.md 에 # first-repository 라는 글을 작성하였습니다. 이제 ls 파일목록을 확인하고, cat 으로 내용을 확인 해보겠습니다.
ls
cat readme.md


8. git status 확인
git status 명령어를 사용하면 현재 저장소의 상태를 확인할 수 있습니다. 방금 readme.md 파일을 만들어 주었습니다. 그래서 이러한 변화를 git status를 통해 확인해봅시다.
git status


git status 명령어는 현재 작업 중인 브랜치, 커밋할 변경 사항, 추적되지 않은 파일 등의 정보를 표시합니다. 여기서 Untracked file 이라고 새로운 파일을 확인하였습니다. 이제 git에 이 변경 사항을 저장해봅시다. 그러기 위해 add와 commit을 이해해야 합니다.
9. add와 commit의 개념

git 에서 파일의 변경 사항을 저장소에 반영하는 과정은 다음과 같습니다. 우선 아래 3가지 개념을 알아야합니다.
Working Directory: 파일을 수정하는 작업 공간입니다.
Index (Staging Area): commit 할 파일들을 준비하는 공간
HEAD: 브랜치의 최신 커밋을 가리키는 포인터
git add
변화를 기록하는 준비단계입니다. 작업 디렉토리(Working Directory)에서 변경된 파일을 스테이징 영역(Staging Area)에 추가하는 명령어입니다.
staging 한다, stage에 올려둔다 라고 말하기도 합니다.
git commit
특정 순간의 버전을 스냅샷으로 확정하여 남깁니다.
HEAD 는 최신 커밋을 가리키는 포인터 이므로 HEAD 가 해당 커밋을 가리킵니다.

 

이제 실습 해봅시다!
10. add 후 commit 하기

add와 commit을 차례로 해보겠습니다. 그리고 add와 commit 사이에 git status를 실행하여 저장소의 상태변화도 함께 추적해보겠습니다.

readme.md 파일을 Staging Area에 추가합니다:
git add readme.md




add 하였더니, commit 될 변경 사항으로 새로운 파일 readme.md를 확인하였습니다.

변경 사항을 커밋합니다
git commit -m "new readme file"

-m 과 함께 커밋 메세지를 작성합니다. 어떠한 변경사항을 commit 한것인지 간단히 작성하면 됩니다.





commit 후 status를 확인해보니, ‘nothing to commit’ 이라 더 이상 commit 할 내용이 없음을 확인하였습니다.
11. git log 로 기록 확인하기
git log 명령어를 사용하여 commit 내역을 확인할 수 있습니다:
git log




결과로 commit 해시(SHA-1), 작성자(username, email), 날짜, commit 메시지 등이 출력됩니다. SHA-1 해시는 각 commit을 고유하게 식별하는 40자리의 16진수 문자열입니다. 이후 문제가 생겨서 버전을 되돌리고자 할때, 이를 기준으로 특정 시점으로 돌아갈 수 있습니다.
12. 원격 저장소(repository) 생성하기

이제 Github에서 "first-repository"라는 이름으로 새로운 원격 저장소를 생성하겠습니다.
Github 에 로그인 후 your repository로 이동합니다.


우측 상단의 초록색 NEW 버튼을 눌러 새로운 레포지토리를 만들어보겠습니다.
Repository name : first-repository
Public 체크 !
로컬의 readme 파일을 사용할 것이기 때문에, Add a README file 는 체크해제
create repository 클릭!


레포지토리가 잘 생성되었다면 아래 사진의 좌상단에 레포지토리의 이름이 나올겁니다.


13. 로컬 저장소와 원격 저장소 연결하기

위 사진의 원격 저장소 주소를 통해 두 저장소를 연결할 수 있습니다. 다음 명령어를 사용하여 로컬 저장소와 원격 저장소를 연결합니다:
git remote add origin <https://github.com/your-username/first-repository.git>

아래와 같이 제 원격 저장소 주소로 사용하였습니다. 방금 만든 여러분의 원격 저장소 주소로 해보세요. 단, 이때 이 명령어는 로컬 저장소의 디렉토리에서 실행해야합니다. 본 실습의 경우 ~/aiffel/workplace 가 되겠네요.
git remote add origin <https://github.com/NamcheolHer/first-repository.git>
git remote add 명령어를 사용할 때, origin은 원격 저장소의 별칭(alias)입니다. 이 별칭은 원격 저장소의 URL을 간단히 표현하는 데 사용됩니다.

origin은 일반적으로 많이 사용되는 원격 저장소 별칭이지만, 사실 다른 이름으로 변경할 수도 있습니다. 예를 들어, git remote add my-repo <https://github.com/user/repo.git과> 같이 사용할 수 있겠습니다.

원격 저장소 별칭을 사용하면 긴 URL을 입력하는 대신, 짧고 간단한 이름으로 원격 저장소를 참조할 수 있습니다. 예를 들면:
git push origin main: origin이라는 별칭을 가진 원격 저장소의 main 브랜치에 변경 사항을 푸시합니다.
git pull origin develop: origin이라는 별칭을 가진 원격 저장소의 develop 브랜치에서 변경 사항을 가져와 현재 브랜치와 병합합니다.
이런 식으로 origin이라는 별칭을 사용하면, 원격 저장소와 관련된 다양한 깃 명령어에서 URL을 반복해서 입력할 필요가 없어져 편리합니다.

물론, 프로젝트에 따라 여러 개의 원격 저장소를 사용할 수도 있습니다. 그런 경우에는 각 원격 저장소마다 다른 별칭을 지정하면 하여 사용합니다. 하지만 대부분의 경우 origin이라는 별칭으로 시작하는 것이 일반적입니다.

연결을 했다고 해서 곧장 로컬에서 원결 저장소로 전송할 수 있는 것은 아닙니다. Github 계정에서 토큰을 생성하고, 토큰을 사용하여 계정을 등록 해야합니다.
14. 토큰 생성

깃헙에서 개인 액세스 토큰(Personal Access Token)을 생성할 수 있습니다. Settings > Developer Settings > 개인 액세스 토큰 에서 "Generate new token"을 클릭하고, 필요한 권한을 선택한 후 토큰을 생성합니다. 자세한 절차는 아래 사진을 함께 따라해주세요.
프로필을 누르고 Settings > Developer Settings 으로 들어갑니다.


Personal access tokens > Tokens > Generate new token 을 차례로 클릭합니다.


Note 를 간단히 작성합니다. 저는 ‘sample token for my first repo’ 라고 작성하였습니다.


Expiration(유효기간) 과 Select scopes (토큰의 권한) 을 설정해주세요. 저는 repo, admin:repe_hook, delete_repo 이렇게 3가지를 체크 하였습니다.


스크롤을 아래로 쭉 내려서, Generate token 합니다.


토큰생성이 완료되었습니다. 토큰 코드는 절대로 외부로 노출하셔는 안됩니다. 꼭 주의하세요.


이제 로컬로 돌아가 토큰으로 계정등록을 합니다.
15. 계정등록후 원격 저장소 전송하기

이제 commit 내용을 push 하여 원격 저장소에 변경사항을 전달해보겠습니다. 저는 브랜치 이름이 main 이 아니라, master 이기에 master로 입력하여 진행하였습니다.
git push origin main
Username for '<https://github.com>': [계정에 사용된 닉네임을 입력하세요]
Password for 'https://[이메일]@github.com': [비밀번호(토큰)를 입력하세요]


이때 토큰은 붙여넣기 하여도 보이지 않을 수 있습니다.
16. 원격 저장소 변경 확인하기

이제 Github의 first-repository로 돌아가 보겠습니다. 그러면 아래와 같이 readme 파일이 잘 반영되었습니다. 여기까지 git 과 Github 을 통해 로컬 저장소와 원격 저장소를 연결해보았습니다.



git branch 란?

https://nulab.com



브랜치는 여러분이 작업 중인 프로젝트에서 새로운 기능을 개발하거나, 버그를 수정할 때 사용하는 독립적인 작업 공간입니다. 브랜치를 사용하면 메인 프로젝트에 영향을 주지 않고 안전하게 작업할 수 있습니다.

브랜치를 만들어, 현재 프로젝트의 상태를 복사하여 별도의 공간에서 작업을 진행하게 됩니다. 이렇게 하면 여러 가지 아이디어를 동시에 시도해볼 수 있습니다. 브랜치에서의 변경 사항이 만족스러우면, 다시 메인 프로젝트에 합칠 수 있습니다. 이를 "병합(merge)"한다고 합니다.
git branch 활용 사례
새로운 기능 개발
기존 프로젝트에 새로운 기능을 추가하고 싶을 때, 브랜치를 만들어 작업합니다.
예를 들어, 온라인 쇼핑몰에 "위시리스트" 기능을 추가한다고 해봅시다
"위시리스트" 브랜치를 만들어 작업하면, 메인 프로젝트에 영향을 주지 않고 안심하고 개발할 수 있습니다.
개발이 완료되면 메인 프로젝트와 병합하면 되죠.
버그 수정
프로젝트에서 버그가 발견되었을 때, 브랜치를 만들어 수정 작업을 진행합니다.
가령, 사용자 로그인에 문제가 있다고 할 경우 "로그인-버그-수정" 브랜치를 만들어 작업하면, 메인 프로젝트는 그대로 운영되는 동안 버그를 수정할 수 있습니다.
수정이 완료되면 다시 메인 프로젝트와 병합합니다.
실험적인 시도
새로운 아이디어를 시도해보고 싶을 때, 브랜치를 활용할 수 있습니다.
웹사이트 디자인을 변경해보는 것이 한 예가 될 수 있겠습니다.
"새로운-디자인" 브랜치를 만들어 작업하면, 기존 디자인에 영향을 주지 않고 다양한 시도를 해볼 수 있습니다.
결과가 마음에 들면 메인 프로젝트와 병합하고, 그렇지 않으면 브랜치를 삭제하면 됩니다.

이렇게 브랜치를 활용하면 프로젝트를 더욱 유연하게 관리할 수 있습니다. 개발 과정에서 브랜치는 매우 유용한 도구랍니다!
마무리

여기까지 간단한 git 과 Github 실습 및 branch 에 대하여 알아보았습니다. 아래 참고자료도 추가할테니 git 과 Github을 더 자세히 실습해보길 권장합니다!
