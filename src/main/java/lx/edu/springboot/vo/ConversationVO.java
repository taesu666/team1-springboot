
package lx.edu.springboot.vo;

public class ConversationVO {
    private int conversationId;   // 댓글 고유번호 (PK)
    private String userId;        // 사용자 아이디(닉네임)
    private String content;       // 댓글 내용
    private int targetId;         // 화면 구분 ID (사주 몇 번째 등)
    private int type;             // 화면 타입 구분 (사주, 궁합 등)
    private int loginId;          // 로그인 유저 고유번호 (정수)
// 작성 시간
    
    public ConversationVO() {}

    // getter/setter
    public int getConversationId() {
        return conversationId;
    }
    public void setConversationId(int conversationId) {
        this.conversationId = conversationId;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public int getTargetId() {
        return targetId;
    }
    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public int getLoginId() {
        return loginId;
    }
    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

}
