Hello JSP!

<%= (1+24) %>

<button onclick = "MainForm.disableLoadContent();"> Disable </button>

<button onclick = "MainForm.enableLoadContent();"> Enable </button>

<form id = "content_form" name="content_form" method="post" action="login/ok.jsp">

 <input  type="text" name="telephone" maxlength="30" size="30">

 <button onclick = " MainForm.submitContent(); return false;">Submit</button>

 </form>
