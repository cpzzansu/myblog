<script></script>
<template>
  <body>
    <article id="38ed2cd6-b000-47b9-b951-1a40b36e7e0a" class="page sans">
      <div class="page-body">
        <p id="58110985-38ef-4ed4-abd6-049da6568e24" class=""></p>
        <p id="303aee33-3a00-4073-99c3-3057042f1998" class="">
          교육원 동기들이 api를 열심히 공부하길래 저도 같이 api를 공부하다가
          Vue.js까지 공부하게 되었습니다. 원래는 react를 공부하고 있었지만, 일단
          Vue.js부터 공부하고, 나중에 react를 공부해보는 것으로 했습니다. 그런데
          작은 문제가 있었습니다. 그럼
          <strong>‘Vue.js 프로젝트는 따로 세팅해야해?’</strong> 라는 의문이죠.
        </p>
        <p id="5ef42020-2516-4399-bbc5-27ef29f0e5d9" class=""></p>
        <p id="bf408c7b-d7f1-4146-b01c-cd9dc517c621" class="">
          배포시에 따로 프로젝트를 실행해주는 건 맞습니다. 스프링부트는 api
          요청에 의한 데이터 응답만 해주면 되기 때문이죠. 하지만
          <strong>개발은 한 툴에서 같이 하는?</strong> 물론 백엔드와 프론트엔드
          개발을 따로 한다면 뭐.. 그럴 필요는 없겠지만, 저는 풀스택이고, 같이
          개발하기 때문에 한 툴에서 같이 개발하고 싶었습니다. 실제로 많이들
          그렇게 하고 있더군요?
        </p>
        <p id="e4e37fa7-e47d-49d9-8643-7805fa6ab966" class=""></p>
        <p id="c863d775-5ba3-4eef-9aee-d433340dd8d1" class="">
          Vue.js 프로젝트를 Spring project 안에 넣는 방법에 대해서 알아보도록
          하겠습니다.
        </p>
        <p id="823229d2-ba46-44b6-96a7-f4145a71c0ef" class=""></p>
        <h2 id="dae31d0d-3aed-4a66-8bd3-27cb297b86e8" class="">
          1. 스프링 프로젝트를 생성한다.
        </h2>
        <p id="ecd72670-1c0f-4483-8f5d-accccef9c667" class=""></p>
        <p id="70d4f942-4e3f-4e38-959c-bcfb9c726b7b" class="">
          가장 첫 번째로 해야할 일은 스프링 프로젝트를 생성하는 것입니다.
          저는<strong> 인텔리제이 IDEA</strong>를 사용하고 있고,
          <strong>IntelliJ IDEA 2023.2 (Ultimate Edition)</strong> 버전을
          사용하고 있습니다.
        </p>
        <p id="bbfa81da-9c4a-472e-8cb5-8b3416b99da3" class=""></p>
        <p id="7cfcec7c-b715-4221-83bb-81bd1878715d" class=""></p>
        <p id="d44afb7d-9496-4e35-b2af-ca9bd69dccb7" class=""></p>
        <p id="32c95316-3867-45fc-91fe-201796784a9d" class="">
          스프링 프로젝트를 생성하면 자연스럽게 이런 파일 구조가 완성이 됩니다.
        </p>
        <p id="5de4e165-59e7-4d21-9e0a-fcad141d7acd" class=""></p>
        <p id="cd7ccdc3-8380-4579-babb-499e9019deee" class="">
          그럼 우리가 해야 할 첫 번째는 끝이 났습니다.
        </p>
        <p id="4b5e1a84-14c8-4934-8350-e81257c5164e" class=""></p>
        <h2 id="15688c2e-4b38-4d9e-ac79-0ff37cede7a5" class="">
          2. Vue.js 프로젝트 생성하기
        </h2>
        <p id="ee3efd25-b8ec-424f-b80a-010373957328" class="">
          Vue.js를 설치하는 법은 다음에 올리면 링크를 걸어두기로 하겠습니다.
          혹시 만약 Vue.js를 설치해야한다면 알아서 찾아봐서 설치하시길 바랍니다.
          ^^
        </p>
        <p id="3d0a0b9d-53a2-4708-a904-dbf591bf9c9a" class=""></p>
        <pre
          id="fc776bc3-194d-4797-a35a-3340249285f1"
          class="code"
        ><code>myblog&gt; vue --version
@vue/cli 5.0.8</code></pre>
        <p id="dac78c68-f0f2-4ca4-93cc-4d0e28639b2b" class=""></p>
        <p id="0ff3c881-7c92-46a9-8252-519fbbe0a895" class="">
          저의 Vue.js 버전은 5.0.8 버전입니다. 참고하시길 바래요. 제가 Vue.js와
          Spring Security를 공부하니 이 버전문제가 상당히 우리를 괴롭게
          하더라구요. 분명 하라는데로, 책에 나온대로 해도 안되서 보면 버전이
          거의 왠만하면 버전문제였습니다.
        </p>
        <p id="5122a04f-5838-43bb-989c-0f19a540d26a" class=""></p>
        <p id="d5881a33-2916-4869-a1fa-914b800655ad" class="">
          그렇다고 책에 나온 구닥다리 버전을 쓰기에는 자존심이 허락하지 않으니
          열심히 고생하는 수 밖에 없었죠! 그래서 왠만하면 버전정보를 꼭
          써야겠구나 하는 생각이 들었습니다.
        </p>
        <p id="570222d2-4ca9-4189-a49d-15c1737d8a45" class=""></p>
        <h3 id="f725c28c-aa49-40b8-bd9e-47ad8dd70120" class="">
          2-1. Vue.js 프로젝트 생성
        </h3>
        <p id="7cdbc5cb-6b9c-491a-895e-c942e1007322" class=""></p>
        <pre
          id="8e008b04-2a52-43ca-99d9-56f8f43dad9e"
          class="code"
        ><code>vue create 프로젝트명</code></pre>
        <p id="0f2294c2-9a8c-433e-a3f4-8d6cfeb4649b" class=""></p>
        <p id="59272566-c4d4-4d22-a328-42f0a0a35990" class="">
          을 하게되면 Vue.js의 버전을 선택할 수 있다. 원하는 버전을
          선택해줍니다.
        </p>
        <p id="67b30903-4005-407c-8a58-8ecef5eca00b" class=""></p>
        <p id="3b830457-c800-490b-be8f-cdd95cb3983c" class=""></p>
        <p id="6b7067c7-0c79-4b70-a3d0-2e72f353c09d" class="">
          그럼 이렇게 프로젝트 설치가 됩니다.
        </p>
        <p id="6d565ec9-dad9-4920-a703-034576704ead" class=""></p>
        <p id="69be0d9e-4012-4436-bef4-fb8a866f14bb" class=""></p>
        <p id="bc77f06e-74dc-4147-bced-df79ed226a97" class="">
          이런식으로 myblog라는 스프링 프로젝트에 front end라는 폴더가 자리 잡게
          됩니다. 이제 이 myblog라는 폴더를 git에 연결하면, 버전관리까지 한번에
          가능하게 됩니다. 깃 연결은 여기로!
        </p>
        <p id="6106d30c-7e89-4793-9fdb-6d53c2cb2c4c" class=""></p>
        <p id="969573a9-adfb-4326-95fb-26119dcdef2c" class="">링크</p>
        <p id="d1cd92f8-0888-4ad4-8878-d94ce1de1430" class=""></p>
        <p id="1e0307d9-69dc-45ec-960c-44cea78189f2" class="">
          저는 다른 사람들 보니까 저렇게 frontend라는 이름으로 폴더를 만들어서,
          vue create 할 때 프로젝트명을 frontend로 했습니다. 그럼 모두들 공부
          열심히 하세요~
        </p>
      </div>
    </article>
  </body>
</template>
<style scoped>
body {
  color: #d4d4dc;
  text-align: left;
  font-family: Pretendard-Regular, 'Apple SD Gothic Neo';
  font-weight: 400;
  letter-spacing: -0.02px;
  font-style: normal;
}
strong {
  font-weight: 900;
}
p {
  font-size: 18px;
  line-height: 160%;
  word-break: break-all;
}
h2 {
  font-size: 2rem;
}
h2,
h3,
h4,
h5 {
  line-height: 150%;
  margin-bottom: 0.5rem;
  font-weight: 500;
}
pre {
  padding: 34px 16px 32px 32px;
  background-color: #2a2a2f;
}
code {
  font-family: Consolas, SFMono-Regular, Menlo, 'PT Mono', 'Liberation Mono',
    Courier, monospace;
}
</style>
