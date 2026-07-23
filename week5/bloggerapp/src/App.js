import React from 'react';
import './App.css';

export const books = [
  { id: 101, bname: 'Master React', price: 670 },
  { id: 102, bname: 'Deep Dive into Angular 11', price: 800 },
  { id: 103, bname: 'Mongo Essentials', price: 450 }
];

export const blogs = [
  { id: 201, btitle: 'React Learning', author: 'Stephen Biz', desc: 'Welcome to learning React!' },
  { id: 202, btitle: 'Installation', author: 'Schewzdenier', desc: 'You can install React from npm.' }
];

export const courses = [
  { id: 301, cname: 'Angular', date: '4/5/2021' },
  { id: 302, cname: 'React', date: '6/3/2020' }
];

function App() {
  const bookdet = (
    <ul>
      {books.map((book) => (
        <div key={book.id}>
          <h3>{book.bname}</h3>
          <h4>{book.price}</h4>
        </div>
      ))}
    </ul>
  );

  const content = (
    <ul>
      {blogs.map((blog) => (
        <div key={blog.id}>
          <h2>{blog.btitle}</h2>
          <b>{blog.author}</b>
          <p>{blog.desc}</p>
        </div>
      ))}
    </ul>
  );

  const coursedet = (
    <ul>
      {courses.map((course) => (
        <div key={course.id}>
          <h2>{course.cname}</h2>
          <p>{course.date}</p>
        </div>
      ))}
    </ul>
  );

  return (
    <div style={{ padding: '20px' }}>
      <div className="container">
        <div className="st2">
          <h1>Course Details</h1>
          {coursedet}
        </div>
        <div className="v1">
          <h1>Book Details</h1>
          {bookdet}
        </div>
        <div className="mystyle1">
          <h1>Blog Details</h1>
          {content}
        </div>
      </div>
    </div>
  );
}

export default App;
