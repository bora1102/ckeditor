package com.cpst.ckEditor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class EditorController {

	@Autowired
	EditorDAO editorDAO;
	
	@RequestMapping("insert")
	public String write(EditorDTO editorDTO) {
		editorDAO.insert(editorDTO);
		return "writeResult";
	}
	
	@RequestMapping(value = "/fileUpload.do")
    public String fileUpload(@ModelAttribute("fileUploadVO") FileUploadDTO fileUploadVO , HttpServletRequest request , Model model){
        HttpSession session = request.getSession();
        String rootPath = session.getServletContext().getRealPath("/");
        String attachPath = "upload/";
 
        MultipartFile upload = fileUploadVO.getUpload();
        String filename = "";
        String CKEditorFuncNum = "";
         
        if(upload != null){
            filename = upload.getOriginalFilename();
            fileUploadVO.setFilename(filename);
            CKEditorFuncNum = fileUploadVO.getCKEditorFuncNum();
            try{
                File file = new File(rootPath + attachPath + filename);
                upload.transferTo(file);
            }catch(IOException e){
                e.printStackTrace();
            }  
        }
            model.addAttribute("filePath",attachPath + filename);          //결과값을
            model.addAttribute("CKEditorFuncNum",CKEditorFuncNum); //jsp ckeditor 콜백함수로 보내줘야함
        return "fileUploadComplete";
    }
    
}
