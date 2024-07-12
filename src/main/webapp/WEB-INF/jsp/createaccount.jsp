<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1>Create Bank Account</h1>
<form:form method="post" action="/bank-accounts/create-account" modelAttribute="bankAccount">
    <table>
        <tr>
            <td><form:label path="accountHolderName">Name</form:label></td>
            <td><form:input path="accountHolderName" /></td>
        </tr>
        <tr>
            <td><form:label path="balance">Balance</form:label></td>
            <td><form:input path="balance" /></td>
        </tr>
        <tr>
            <td><form:label path="accountNumber">Account No</form:label></td>
            <td><form:input path="accountNumber" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Create Account" />
            </td>
        </tr>
    </table>
</form:form>