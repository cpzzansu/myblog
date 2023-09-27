<template>
  <footer>
    <div>
      <div class="company-name">(주)서원닷컴</div>
      <div class="company-information col-12 col-md-12 col-lg-10 col-xl-8">
        대표이사 : 서원 | 사업자 번호 : 123-45-67890 | 통신판매신고번호 : 제
        2023-서울강남-12345호<br />
        대표번호 : 02-1234-5678 | 주소 : 서울시 강남구 논현로168길 12 | ©
        SEOWON .COM all rights reserved
      </div>
    </div>
  </footer>
</template>

<script>
export default {
  name: 'BlogFooter',
};
</script>

<style scoped>
footer {
  height: 300px;
  margin-top: 150px;
  color: white;
  text-align: left;
  padding: 1em;
  bottom: 0;
  width: 100%;
}
.company-name {
  padding-top: 70px;
  font-family: Pretendard, 'Apple SD Gothic Neo';
  font-weight: 700;
  font-size: 18px;
}
.company-information {
  padding-top: 15px;
  font-size: 12px;
}
</style>
