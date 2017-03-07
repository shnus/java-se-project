<script type="text/javascript">
    var url = "broadcast";
    var source=new EventSource(url);
    source.addEventListener(
        "message",
        function(event){
            console.log(event.data);
            document.getElementById("result").innerHTML+=event.data + "<br>"; },
        false);
</script>
<div id="result">
    <form action="broadcast" method="post" enctype="text/plain"  >
        <input  name="hui" placeholder="Put message here"/>
        <input  name="hui2" placeholder="Put message here"/>
        <input type="submit" value="OK"/>
    </form>
</div>