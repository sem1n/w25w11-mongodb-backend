package kr.ac.kumoh.s20240624.w25w11_mongodb_backend.controller

import kr.ac.kumoh.s20240624.w25w11_mongodb_backend.model.Song
import kr.ac.kumoh.s20240624.w25w11_mongodb_backend.service.SongService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/songs")
class SongController(
    private val service: SongService
) {
    // Create
    @PostMapping
    fun addSong(@RequestBody song: Song): Song = service.addSong(song)

    // Read (Retrieve)
    @GetMapping
    fun getAllSongs(): List<Song> = service.getAllSongs()

    @GetMapping("/{id}")
    fun getSongById(@PathVariable id: String): Song? = service.getSongById(id)

    @GetMapping("/singer/{singer}")
    fun getSongBySinger(@PathVariable singer: String): List<Song> = service.getSongBySinger(singer)

    // Update
    @PutMapping("/{id}")
    fun updateSong(
        @PathVariable id: String,
        @RequestBody songDetails: Song
    ): Song? =  service.updateSong(id, songDetails)

    // Delete
    @DeleteMapping("/{id}")
    fun deleteSong(@PathVariable id: String): Map<String, String> {
        return if (service.deleteSong(id))
            mapOf("status" to "deleted")
        else
            mapOf("status" to "not found")
    }
}