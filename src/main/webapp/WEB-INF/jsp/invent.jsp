<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
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

        body{
            background-color: #A9A9A9;
        }
    </style>



</head>
<body>


<div id="container">
    <h1>Noir Candle & Co.</h1>
    <br>
</div>

<div class="topnav">
    <a href="/">Home</a>
    <a href="/cust_list">Customer</a>
    <a href="/emp_list">Employee</a>
    <a  class="active" href="/invent_list">Inventory</a>
    <a href="/trans_list">Transaction</a>
</div>

<div class="searchi">
    <form action="search" method="get" >
        <input type="text" class="formseatch"  name="q" placeholder="Search here">

    </form>
</div>
<%--<form action="<s:url value="/user/invent_search"/>">
    <input type="text" name="freeText" placeholder="Enter Text to Search">
    <button>Find</button>
</form>--%>
<%--<form action="/invent_list/search">
    <input type="text" name="freeText" placeholder="Enter Text to Search">
    <input type="submit" value="Search">
</form>--%>


<table>
    <tr>
        <%-- <th>Product ID</th>--%>
        <th>ID</th>
        <th>Description</th>
        <th>Price </th>
            <th>Edit/Delete </th>

    </tr>
    <c:forEach var = "inventitem" items = "${inventorylist}">
        <tr>

                <%--<td>${listitem.getId()}</td>--%>
            <td>${inventitem.getInventoryid()}</td>
            <td>${inventitem.getDescription()}</td>
            <td>${inventitem.getPrice()}</td>
            <td>
                    <%--   <a href="/view/${listitem.getId()}">View</a>--%>
                <a href="/edit/${inventitem.getInventoryid()}">Edit</a>

                <a href="/delete_invent/${inventitem.getInventoryid()}"> Delete</a>
            </td>


        </tr>
        <br>

    </c:forEach>


</table>




<form method="post" action="/save">
    <input type="hidden" name="inventoryid" value="${selectedItem.getInventoryid()}">
    <br>Description: <br>
    <input type="text" name="description" value="${selectedItem.getDescription()}">
    <br>Price:<br>
    <input type="text" name="price" value="${selectedItem.getPrice()}">
    <br><br>
    <input type="submit" value="Submit">
</form>

<footer>

</footer>
</body>
</html>
