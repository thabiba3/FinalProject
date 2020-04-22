<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>

    <%-- <style rel="stylesheet" href="css.css"></style>--%>

    <title>Sporting Business Inventory</title>
    <style>

        h3{
            text-align: center;
            text-align: left;
        }
        h1{
            text-align: center;

        }



        #container {
            width: inherit;
            height: inherit;
            margin: 0;
            padding: 0;
            background-color: pink;
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


        /* tr:nth-child(even) {
             background-color: #80ced6;
         }*/

    </style>



</head>
<body>

<div id="container">
    <h1>Candles for you</h1>
    <h3>Customer Information</h3>
    <br>

</div>

<table>
    <tr>
        <%-- <th>Product ID</th>--%>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name </th>
            <th>Number </th>

    </tr>
    <c:forEach var = "listitem" items = "${customerlist}">
        <tr>
            //change testing

                <%--<td>${listitem.getId()}</td>--%>
            <td>${listitem.getCustomerid()}</td>
            <td>${listitem.getFirstname()}</td>
            <td>${listitem.getLastname()}</td>
                    <td>${listitem.getPhonenumber()}</td>


        </tr>
        <br>

    </c:forEach>


</table>
<a href= "/">Home</a>
<a href= "/">Home</a>


<%--<form method="post" action="/emp_list">
    <input type="submit"  value="load new API">
</form>--%>
<footer>

</footer>
</body>
</html>
