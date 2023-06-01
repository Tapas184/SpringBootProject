/**
 * 
 */
 function validate(frm){
	document.getElementById("enameError").innerHTM="";
	document.getElementById("salError").innerHTML="";
	document.getElementById("jobError").innerHTML="";
	
	let name = frm.ename.value;
	let sal = frm.sal.value;
	let job = frm.job.value;
	let vflag = frm.hflag.value;
	let flag=true;
	
	if(name==""){
		document.getElementById("enameError").innerHTML="Employee Name is Required(cs)";
		 flag=false;
	}else if(name.length()<4){
		document.getElementById("enameError").innerHTML="Employee Name Should be Greater Then 4 char(cs)";
		 flag=false;
	}else if(isNaN(sal)){
		document.getElementById("salError").innerHTML="Salary Must Be a numeric value(cs)";
		 flag=false;
	}else if(sal<=10000 || sal>1000000){
		document.getElementById("salError").innerHTML="Salary range must be in between 10,000 and 10,00,000(cs)";
		 flag=false;
	}else if(job==""){
		document.getElementById("jobError").innerHTML="Job Field required(cs)";
		 flag=false;
	}
	vflag="yes";
	return flag;
}