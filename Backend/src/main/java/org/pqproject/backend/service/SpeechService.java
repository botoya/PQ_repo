package org.pqproject.backend.service;

import org.pqproject.backend.pojo.*;

import java.util.Date;
import java.util.List;

public interface SpeechService {
    /**
     * Retrieves a speech by its ID.
     *
     * @param speechId the ID of the speech
     * @return the Speech object if found, null otherwise
     */
    ReturnSpeech getSpeechById(String speechId);

    /**
     * Retrieves all speeches.
     *
     * @return a list of all Speech objects
     */
    List<ReturnSpeech> getAllSpeeches();

    /**
     * Adds a new speech.
     *
     * @param speech the Speech object to be added
     * @return true if the addition was successful, false otherwise
     */
    boolean addSpeech(Speech speech);

    /**
     * Updates an existing speech.
     *
     * @param speech the Speech object with updated information
     * @return true if the update was successful, false otherwise
     */
    boolean updateSpeech(Speech speech);

    /**
     * Deletes a speech by its ID.
     *
     * @param speechId the ID of the speech to be deleted
     * @return true if the deletion was successful, false otherwise
     */
    boolean deleteSpeech(String speechId);

    /**
     * Starts a speech by its ID.
     *
     * @param speechId the ID of the speech to be started
     * @return true if the speech was successfully started, false otherwise
     */
    void startSpeech(String speechId, Date startTime);

    void endSpeech(String speechId, Date endTime);

    boolean joinSpeech(String speechId, String userId);

    List<ReturnSpeech> getMySpeeches(String userId);

    List<ReturnSpeech> getSpeechesBySpeaker(String userId);

    List<ReturnSpeech> getSpeechesByOrganizer(String userId);

    boolean spikeSpeech(Spit spit);

    List<Spit> getSpitsBySpeechId(String speechId);

    List<String> getAudienceBySpeechId(String speechId);

    int getSpeechAudienceCount(String speechId);


    OrganizerData getSpeechData(String speechId);
}
