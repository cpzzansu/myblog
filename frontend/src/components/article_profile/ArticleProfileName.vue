<script></script>
<template>
  <div class="profile-name-div">
    <div class="profile-picture"></div>
    <div>
      <div class="d-flex align-items-center">
        <div class="member-name">이동훈</div>
        <div class="member-job">서원닷컴 개발자</div>
      </div>
      <div>
        <div class="profile-massage">
          <div class="massage-font">제발 나도 제주도 데려가주세요 현정님</div>
        </div>
      </div>
    </div>
  </div>
</template>
<style scoped>
.profile-name-div {
  height: 80px;
  width: 100%;
  padding-top: 2px;
  padding-bottom: 2px;
  background: #00000000;
  justify-content: flex-start;
  align-items: center;
  gap: 5px;
  display: flex;
  border-radius: 12px;
}
.member-name {
  color: white;
  font-size: 19px;
  font-family: Pretendard;
  font-weight: 800;
  word-wrap: break-word;
  margin-left: 10px;
}
.member-job {
  color: #cccccc;
  margin-left: 5px;
  font-size: 5px;
  font-family: Pretendard;
  font-weight: 400;
  word-wrap: break-word;
}
.profile-picture {
  width: 80px;
  height: 80px;
  background: #d9d9d9;
  border-radius: 9999px;
}
.profile-massage {
  height: 51px;
  margin-left: 10px;
  background: #00000000;
  justify-content: flex-start;

  display: inline-flex;
}
.massage-font {
  width: 200px;
  color: #cccccc;
  font-size: 15px;
  font-family: Pretendard;
  font-weight: 400;
  word-wrap: break-word;
}
</style>
