<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>

    <%-- <style rel="stylesheet" href="css.css"></style>--%>

    <title>Sporting Business Inventory</title>
    <style>
        body{
            background-color: #A9A9A9;
        }

        h3{
            text-align: center;

        }
        h1{
            text-align: center;

        }

        body {
            background-image: url('candle.jpg');
            background-repeat: no-repeat;
            background-color: #A9A9A9;

        }

        #container {
            width: inherit;
            height: inherit;
            margin: 0;
            padding: 0;
            background-color: #A9A9A9;
            text-align: center;
        }


        table {
            border-collapse: collapse;
            width: 100%;


        }
        td,th {
            border: 2px solid #252525;
            text-align: left;
            padding: 8px;
        }

        .topnav {
               background-color: #333;
               overflow: hidden;
           }

        .topnav a {
            float: left;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        .topnav a.active {
            background-color: #FFFAF0;
            color: Black;
        }
    </style>

</head>
<body>

<div id="container">
    <h1>Noir Candle & Co.</h1>
     <br>
</div>

     <div class="topnav">
         <a class="active" href="/">Home</a>
             <a href="/cust_list">Customer</a>
          <a href="/emp_list">Employee</a>
         <a href="/invent_list">Inventory</a>
        <a href="/trans_list">Transaction</a>
     </div>

<h1>Welcome to Noir Candles & Co. Inventory Page</h1>
<h3>We deliver with excellence</h3>
<footer>

</footer>
</body>
</html>
