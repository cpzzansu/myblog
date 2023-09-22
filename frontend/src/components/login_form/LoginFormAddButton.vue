<script></script>
<template>
  <div class="addButtonDiv">
    <small
      ><router-link to="/addMember" class="addLink"
        >신규회원가입</router-link
      ></small
    >
    |
    <small
      ><router-link to="#" class="addLink">비밀번호찾기</router-link></small
    >
  </div>
</template>
<style>
.addButtonDiv {
  color: #d1d1d1;
  display: flex;
  justify-content: center;
  margin-top: 40px;
}
.addLink {
  text-decoration: none;
  color: #d1d1d1;
  font-weight: 700;
  font-size: 100%;
}
small:first-child {
  margin-right: 30px;
}
small:last-child {
  margin-left: 30px;
}
</style>
