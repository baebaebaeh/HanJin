function getMemberInfo() {
  return {
    id: "hong",
    age: 22,
    nickName: "홍길동"
  };
}
// json형태의 데이터를 리턴 받으면 let으로 한꺼번에 변수 등록 할 수 있다.
let {id, age, nickName} = getMemberInfo();
console.log(id, age, nickName);

