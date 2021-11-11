package com.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("api/demo")
public class DemoController {
	
	@RequestMapping(value = "demo1", method = RequestMethod.GET, produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> demo1() {
		try {
			return new ResponseEntity<String>("Demo1", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "demo2", method = RequestMethod.GET, produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> demo2() {
		try {
			return new ResponseEntity<String>("Demo2", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "demo3", method = RequestMethod.GET, produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> demo3(HttpServletRequest request) {
		try {
			System.out.println("log3");
			if (request.getAttribute("username") != null) {
				System.out.println("username:" + request.getAttribute("username").toString());
			}
			if (request.getAttribute("id") != null) {
				int id = Integer.parseInt(request.getAttribute("id").toString());
				System.out.println("id:" + id);
			}
			return new ResponseEntity<String>("Demo3", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
}
