const arr = [10, 20, 30, 40];
let [a, b, c] = arr;
console.log(a, b, c);
// console 10 20 30
let [d, e, ...rest] = arr;
console.log(d, e, rest);
// console  10 20 [ 30, 40 ]
/*
let a = arr[0];
let b = arr[1];
let c = arr[2];
*/
const member = {
  id: "hong",
  name: "홍길동",
  age: 22
};
let {id, name: memberName, age} = member;
console.log(id);
console.log(memberName);
console.log(age);


/*

let id = member.id;
// let name = member.name;
let memberName = member.name; // 위에선 이렇게 사용했다. 이름을 바꿔서 사용
let age = member.age;

*/