// node.js를 설치했다면 `node script.js`으로 실행 가능


// Object 선언
const myObject = { 
  name: "haley", 
  food: "pizza", 
  age: 20, 
}

// Object to JSON - stringfy()
// JSON.stringfy(Object)
const objToJson = JSON.stringify(myObject)

console.log(objToJson)        // {"name": "haley"...."food": "pizza"}
console.log(typeof objToJson) // string
console.log(objToJson.age)    // undefined
console.log(objToJson[0])     // {


// JSON to Object - parse()
// JSON.parse(JSON)
const jsonToObj = JSON.parse(objToJson)

console.log(jsonToObj)            // {name: "haley", food: "pizza", age:20}
console.log(typeof jsonToObj)     // object
console.log(typeof jsonToObj.age) // 20
console.log(jsonToObj["age"])     // 20