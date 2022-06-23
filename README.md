<h1>CS 305 - Software Security</h1>
<h2>Lawrence Artl III<br>
  Southern New Hampshire University</h2>
  <p>
  Welcome to the repository for the various projects from my CS 305 Software Security class at SNHU Online! Feel free to browse my code and check out the
  various applications that I developed during the semester. The culmination of my learning can be found in <a href="https://github.com/lorenarms/SNHU_CS_305_Software_Security/tree/main/ssl-server_student" target="_blank">the Final Project</a>. For more information about the project, see 
  <a href="https://github.com/lorenarms/SNHU_CS_305_Software_Security/tree/main/ssl-server_student/Documentation" target="_blank">the documentation</a>.
                                                                                                                               
  </p>
  The client, Artemis Financial, was looking to update the security of their application, serving their users with secure communications. The solution to this was to implement an https protocol for the website, as well as incorporating a hashing algorithm to hash the data that is sent back and forth from server to browser. For the former, the java keytool was used to create a keystore and certificate that the browser could use to access the website securely. To create the hash, a hashing method was written to take in data and return the hashed value to the browser for display.
  <p>
  <h3>Running the Application...</h3>
  <p>
  Within Eclipse (or the Java IDE of your choice), run the application, then navigate in a web browswer to https://localhost:8443. The various endpoints to explore are /hash, /doc, and /greeting. All three of these use the Spring framework to serve data to the user. All three endpoints also accept queries as strings. For example, /hash?name=your name will return "your name"'s hash value. /hash?algorithm=SHA256 will return the object's hash in SHA256 (the default is SHA512). 
  </p>
  
  </p>
  <p>If you're interested, you can see more about my process in <a href="https://youtu.be/sMPwKmfkNI8" target="_blank">this video</a> about the final project, or check out <a href="https://www.youtube.com/channel/UCGtp8PRHgPCQHYoSxbMST8A" target="_blank">my entire YouTube channel</a> for more videos about coding projects I've done.
<p>Also, please check out my <a href="http://artllj.com" target="_blank">Personal Website</a> for more information about me, and my <a href="https://www.linkedin.com/in/lorenarms95/" target="_blank">LinkedIn</a> to get additional information. </p>
<h3>Thanks for stopping by!</h3>
<img src="https://media-exp2.licdn.com/dms/image/C5603AQEqU5vuSjmWrg/profile-displayphoto-shrink_400_400/0/1641574403621?e=1660780800&v=beta&t=hukMeE3aKt4d6lyocOdHmZmJ16QC0bWLUaaT2d_m5Gk" atl="[picture of me]" style="width:100px;height:100px;">
