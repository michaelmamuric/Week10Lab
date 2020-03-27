<%-- 
    Document   : notes
    Created on : Mar 4, 2020, 8:44:02 PM
    Author     : 799470
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>
        <h1>Notes!</h1>
        <table>
            <tr>
                <th>Date Created</th>
                <th>Title</th>
                <th></th>
            </tr>
            <c:forEach var="notes" items="${notesList}">
                <tr>
                    <td>${notes.datecreated}</td>
                    <td>${notes.title}</td>
                    <td>
                        <form method="post">
                            <input type="submit" name="edit" value="Edit" />
                            <input type="hidden" name="noteID" value="${notes.noteid}" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
        <c:if test="${mode == 'view'}">
            <h2>Add Note</h2>
            <form method="post" id="addNote">
                Title: <input type="text" name="noteTitle" /><br />
                Content: <br />
                <textarea name="noteContent" cols="25" rows="10"></textarea><br />
                <input type="submit" name="add" value="Add" />
            </form>
        </c:if>
            
        <c:if test="${mode == 'edit'}">
            <h2>Edit Note</h2>
            <form method="post" id="editNote">
                <input type="hidden" name="selectedNoteID" value="${selectedNoteID}" />
                <input type="submit" name="delete" value="Delete Note" onclick="return confirm('Are you sure you want to delete this note?')" /><br />
                Title: <input type="text" name="noteTitle" value="${noteTitle}" /><br />
                Content: <br />
                <textarea name="noteContent" cols="25" rows="10">${noteContents}</textarea><br />
            </form>
        </c:if>
    </body>
</html>
