package ita3.car.api;

import ita3.car.entity.Member;
import ita3.car.repository.IMemberRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {

    IMemberRepository memberRepository;

    public MemberController(IMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // READ-ALL -> GET
    @GetMapping("/members")
    public ResponseEntity<List<Member>> getAllMembers(){
        return ResponseEntity.ok().body(memberRepository.findAll());
    }

    // READ -> GET
    @GetMapping("/members/{id}")
    public ResponseEntity<Optional<Member>> getOneMember(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(memberRepository.findById(id));
    }

    // CREATE -> POST
    @PostMapping("/members")
    public ResponseEntity<Member> createMember(@RequestBody Member member){
        Member savedMember = memberRepository.save(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
    }

    // UPDATE -> PUT
    @PutMapping("/members/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable String id, @RequestBody Member member){
        if(!memberRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Member updatedMember = memberRepository.save(member);
        return ResponseEntity.status(HttpStatus.OK).body(updatedMember);
    }

    // DELETE -> DELETE
    @DeleteMapping("/members/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable String id){
        if(!memberRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        memberRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

