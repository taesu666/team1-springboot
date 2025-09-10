## 우리 모두 Git을 뿌셔보아요👊

### 알고 있자
- 워크스페이스는 워킹 디렉토리가 될 수 없음 \
-> 워크스페이스를 하나 만들고 그 안에 폴더를 만들어줘야함 \
-> 그리고 그걸 워킹 디렉토리로 지정하기
  
**복붙**
-	복사: `Ctrl + Insert`
-	붙여넣기: `Shift + Insert`

### 커밋 과정
1. 이클립스 파일 수정
2. 폴더 지정
- `$ cd C:\12\SpringBootProject\SBP`
3. 깃허브 연결
-	`git remote remove origin` - 이전 연결 삭제
-	`git remote add origin https://github.com/taesu666/team1-springboot`
4. 유저정보 입력
-	`git config --global user.name "ji-gaem2"`
-	`git config --global user.email "denver6761@gmail.com"`
5. 브랜치 확인 - 안됐으면 브랜치 이동
-	`git branch`
6. 커밋할 수 있는 파일 확인
-	`git status`
- 결과
```
On branch jigaem
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
    modified:   target/classes/META-INF/maven/lx.edu/myspringboot/pom.properties

Untracked files:
  (use "git add <file>..." to include in what will be committed)
    src/main/java/lx/edu/springboot/vo/UserVO.java

no changes added to commit (use "git add" and/or "git commit -a")
```
7. 스테이징 영역에 파일 올리기 - 
-	`git add -A`
8. 깃에 파일 올리기 - `-m`뒤에 오는건 commit메세지(큰따옴표 써주기)
-	`git commit -m "add UserVO"`
9. 깃허브에 파일 올리기 - `jigaem`은 푸시할 브랜치 이름 - 각자 이름의 브랜치로 올리기
-	`git push -u origin jigaem`
- 결과
```
$ `git push -u origin jigaem`
Enumerating objects: 32, done.
Counting objects: 100% (32/32), done.
Delta compression using up to 8 threads
Compressing objects: 100% (11/11), done.
Writing objects: 100% (17/17), 1.43 KiB | 732.00 KiB/s, done.
Total 17 (delta 2), reused 0 (delta 0), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (2/2), completed with 2 local objects.
To https://github.com/taesu666/team1-springboot
   3d3f029..8ff63af  jigaem -> jigaem
bash: branch: command not found
```
