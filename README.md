## Test Case
```JavaScript
await fetch('http://localhost:8080/auth/login', { method: 'post', body: JSON.stringify({ username: 'lilonghe', password: '123456' }), headers: { 'Content-Type': 'application/json' } })
await fetch('http://localhost:8080/product', { method: 'get', credentials: "omit", headers: { 'Content-Type': 'application/json', 'Authorization': 'Bearer REAL JWT TOKEN' } })
await fetch('http://localhost:8080/auth/logout', { method: 'delete', headers: { 'Content-Type': 'application/json' } })
```