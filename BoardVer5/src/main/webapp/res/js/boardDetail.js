function delCmt(iboard, icmt) {
	console.log('iboard : ${iboard}, icmt: ${icmt}'); /* %d문법으로 해도 가능 (자바표현식)*/
	if(confirm('삭제하시겠습니까?')) {
		location.href = '/board/cmt?icmt=${icmt}&iboard=${iboard}';
	}
	/*자바스크립트 파일로 만들어서 사용하면 상관없지만 jsp에서 사용하면 EL식으로 읽기 때문에 앞에 역슬러시 |를 넣어줘야한다.
	하지만 스크립트는 무조건 파일을 분리해야한다. 
	  */
}