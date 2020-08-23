<%--
  Created by IntelliJ IDEA.
  User: Akita
  Date: 2020/8/23
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
  <script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
  <script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
  <script>
    window.onload = function () {
      new Vue({
        el: '#ajaxTest',
        data: {
          username: "",
          password:""
        },
        methods: {
          send: function (url,data,suc) {
            $.ajax({
              type: "POST",
              url: url,
              dataType:"text",
              contentType: 'application/json',
              data:JSON.stringify(data),
              success: function(msg){
                alert(msg);
                if(suc!=null)
                  suc(msg);
              }
            });
          },
          test: function(){
            this.send("test",{username:this.username},null)
          },
          login: function(){
            this.send("login",{
              username:this.username,
              password: this.password
            },null)
          }
        }
      })
    }
  </script>
</head>

<body>
<div id="ajaxTest">
  username:<input name="username" v-model="username"/><br/>
  password:<input name="password" v-model="password"/><br/>
  <button @click="test()">test</button>
  <button @click="login()">login</button>
</div>
</body>
</html>
