const name = 1000;
// 선언문
function fn1(name, msg) {
  console.log("fn1");
}
// 화살표 함수
const fn2 = (name, msg) => {
  console.log("fn2");
}


// 매개변수가 하나일때는 어떻게 할까요~?
const f3 = name => {
  console.log(name);
}


f3(name);