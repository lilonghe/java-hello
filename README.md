## Test Case
```JavaScript
await fetch('http://localhost:8080/auth/login', { method: 'post', body: JSON.stringify({ username: 'lilonghe', password: '123456' }), headers: { 'Content-Type': 'application/json' } })
```