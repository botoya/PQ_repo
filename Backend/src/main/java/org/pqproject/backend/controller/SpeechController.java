package org.pqproject.backend.controller;

import org.pqproject.backend.pojo.*;
import org.pqproject.backend.service.QuestionService;
import org.pqproject.backend.service.SpeechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/speech")
public class SpeechController {
    @Autowired
    private SpeechService speechService;

    @RequestMapping("/getSpeechById")
    public ReturnSpeech getSpeechById(@RequestParam String speechId) {
        return speechService.getSpeechById(speechId); // Return the speech details as a string
    }

    //获取所有演讲
    @RequestMapping("/getAllSpeeches")
    public List<ReturnSpeech> getAllSpeeches() {
        return speechService.getAllSpeeches(); // Return the list of all speeches
    }

    @RequestMapping("/addSpeech")
    public String addSpeech(@RequestBody Speech speech) {
        if (speechService.addSpeech(speech)) {
            return "演讲添加成功"; // Return a success message
        } else {
            return "演讲添加失败，演讲ID已存在"; // Return an error message
        }
    }

    @RequestMapping("/updateSpeech")
    public String updateSpeech(@RequestBody Speech speech) {
        if (speechService.updateSpeech(speech)) {
            return "演讲更新成功"; // Return a success message
        } else {
            return "演讲更新失败，演讲ID不存在"; // Return an error message
        }
    }

    @RequestMapping("/deleteSpeech")
    public String deleteSpeech(@RequestParam String speechId) {
        if (speechService.deleteSpeech(speechId)) {
            return "演讲删除成功"; // Return a success message
        } else {
            return "演讲删除失败，演讲ID不存在"; // Return an error message
        }
    }

    @RequestMapping("/startSpeech")
    public String startSpeech(@RequestParam String speechId) {
        speechService.startSpeech(speechId, new Date()); // Start the speech with the current time
        return "演讲已开始"; // Return a success message indicating the speech has started
    }

    @RequestMapping("/endSpeech")
    public String endSpeech(@RequestParam String speechId) {
        speechService.endSpeech(speechId, new Date()); // End the speech with the current time
        return "演讲已结束"; // Return a success message indicating the speech has ended
    }

    // 用户加入演讲
    @RequestMapping("/joinSpeech")
    public String joinSpeech(@RequestParam String speechId, @RequestParam String userId) {
        if (speechService.joinSpeech(speechId, userId)) {
            return "用户已加入演讲"; // Return a success message indicating the user has joined the speech
        } else {
            return "用户加入演讲失败，可能是演讲ID不存在或用户已加入"; // Return an error message
        }
    }

    //用户查看自己参与过的演讲
    @RequestMapping("/getMySpeeches")
    public List<ReturnSpeech> getMySpeeches(@RequestParam String userId) {
        return speechService.getMySpeeches(userId); // Return the list of speeches the user has joined
    }

    //演讲者获取自己主讲的所有演讲
    @RequestMapping("/getSpeechesBySpeaker")
    public List<ReturnSpeech> getSpeechesBySpeaker(@RequestParam("userId") String userId) {
        return speechService.getSpeechesBySpeaker(userId);
    }

    //组织者获取自己组织的所有演讲
    @RequestMapping("/getSpeechesByOrganizer")
    public List<ReturnSpeech> getSpeechesByOrganizer(@RequestParam("userId") String userId) {
        return speechService.getSpeechesByOrganizer(userId); // Return the list of speeches organized by the user
    }

    //组织者或演讲者获取听众列表
    @RequestMapping("/getAudienceBySpeechId")
    public List<String> getAudienceBySpeechId(@RequestParam String speechId) {
        return speechService.getAudienceBySpeechId(speechId); // Return the list of audience members for the specified speech
    }

    //听众吐槽演讲情况
    @RequestMapping("/SpikeSpeech")
    public String SpikeSpeech(@RequestBody Spit spit) {
        System.out.println(spit.toString());
        if (speechService.spikeSpeech(spit)) {
            return "演讲吐槽成功"; // Return a success message indicating the feedback was successful
        } else {
            return "演讲吐槽失败，可能是演讲ID不存在或用户未加入演讲"; // Return an error message
        }
    }

    //组织者或演讲者获取演讲的所有吐槽
    @RequestMapping("/getSpitsBySpeechId")
    public List<Spit> getSpitsBySpeechId(@RequestParam String speechId) {
        return speechService.getSpitsBySpeechId(speechId); // Return the list of feedback for the specified speech
    }

    //组织者获取演讲人数
    @RequestMapping("/getSpeechAudienceCount")
    public int getSpeechAudienceCount(@RequestParam("speechId") String speechId) {
        return speechService.getSpeechAudienceCount(speechId); // Return the count of audience members for the speech
    }


    //组织者获取演讲数据
    @RequestMapping("/getSpeechData")
    public OrganizerData getSpeechData(@RequestParam("speechId") String speechId) {
        System.out.println("组织者获取演讲数据...................................................");
        return speechService.getSpeechData(speechId); // Return the data for the specified speech
    }

}
