/** 收起隐藏 效果 */
function closedParent(val)
{
	//元素是否隐藏 */
	var sign = $("#metric-list" + val + "").is(':hidden');
	if(sign)
	{
		//如果元素隐藏,则展开 时间为500毫秒 同时改变样式
		$("#metric-list" + val + "").slideDown(500,function(){
			$("#open"+val+"").removeClass("close").addClass("open");
		});
	}else
	{
		$("#metric-list" + val + "").slideUp(500,function(){
			$("#open"+val+"").removeClass("open").addClass("close");
		});
	}
}