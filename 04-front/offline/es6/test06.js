const arr = [1, 10, 100];
console.log(...arr);

// 기존요소에 추가해서 만들 수 있다.
const arr2 = [2, 20, 200, ...arr];
console.log(arr2);

const obj1 = {id: "hong", age:22, email: "kim@kim.com"};
const obj2 = {email: "hong@hong.com", ...obj1};
console.log(obj2);
// { email: 'kim@kim.com', id: 'hong', age: 22 }

const obj3 = {id: "hong", age:22, email: "kim@kim.com"};
const obj4 = {...obj1, email: "hong@hong.com"};
console.log(obj4);
// { id: 'hong', age: 22, email: 'hong@hong.com' }

/*
for (let i = 0; i < arr.length; i++) {
  arr2[i] = arr[i];
}
*/

function fn(a, b, c) {
  console.log(a, b, c);
}
const a = [100, 200, 300];
fn(...a);
// fn(a[0], a[1], a[2]);