<div class=datepicker>
<form id=datepicker>
    <label>C </label>
    <input id="dateBegin" name="dateBegin" type="date" min="2015-10-24" placeholder="yyyy-MM-dd"/>
    <label>По </label>
    <input id="dateEnd" name="dateEnd" type="date" min="2015-10-24" placeholder="yyyy-MM-dd"/>
    <button type="button" onclick="sortUsers()">Найти</button>

</form>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script type="text/javascript" src="<@spring.url "/resources/js/datepicker.js"/>"></script>
</div>