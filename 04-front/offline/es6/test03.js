const num = 100;

function fn1(num) {
  return num * num;
}
// 화살표 함수
const fn1_a = (num) => {
  return num * num;
}
// return 생략가능 return이 한줄이면
// 화살표 함수
const fn1_b = (num) => num * num;



console.log(fn1_a(num));
console.log(fn1_b(num));