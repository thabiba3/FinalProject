<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>

    <%-- <style rel="stylesheet" href="css.css"></style>--%>

    <title>Sporting Business Inventory</title>
    <style>

        h3{
            text-align: center;

        }
        h1{
            text-align: center;

        }

        body{
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
    <a  href="/">Home</a>
    <a  class="active" href="/cust_list">Customer</a>
    <a href="/emp_list">Employee</a>
    <a href="/invent_list">Inventory</a>
    <a href="/trans_list">Transaction</a>
</div>



<form method="post" action="/save_cust">
    <input type="hidden" name="customerid" value="${selectedItem.getCustomerid()}">
    <br>First Name: <br>
    <input type="text" name="firstname" value="${selectedItem.getFirstname()}">
    <br>
    Last Name:<br>
    <input type="text" name="lastname" value="${selectedItem.getLastname()}">
    <br>
  Phone Number:<br>
    <input type="text" name="phonenumber" value="${selectedItem.getPhonenumber()}">
    <br><br>
    <input type="submit" value="Submit">
</form>

<footer>

</footer>
</body>
</html>
