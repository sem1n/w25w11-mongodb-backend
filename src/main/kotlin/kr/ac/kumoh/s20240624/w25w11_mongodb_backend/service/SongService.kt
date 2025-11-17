package kr.ac.kumoh.s20240624.w25w11_mongodb_backend.service

import kr.ac.kumoh.s20240624.w25w11_mongodb_backend.model.Song
import kr.ac.kumoh.s20240624.w25w11_mongodb_backend.repository.SongRepository
import org.springframework.stereotype.Service

@Service
class SongService(
    private val repository: SongRepository
) {
    fun getAllSongs(): List<Song> = repository.findAll()
}