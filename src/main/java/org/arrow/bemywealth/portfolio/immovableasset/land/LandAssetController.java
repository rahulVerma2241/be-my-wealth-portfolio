package org.arrow.bemywealth.portfolio.immovableasset.land;

import lombok.AllArgsConstructor;
import org.arrow.bemywealth.portfolio.immovableasset.land.dto.LandDto;
import org.arrow.bemywealth.portfolio.immovableasset.land.service.LandAssetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/immovable/land")
@AllArgsConstructor
@CrossOrigin("http://localhost:5173")
public class LandAssetController {

    private final LandAssetService landAssetService;

    @GetMapping("all")
    public ResponseEntity<List<LandDto>> getAllLands(@RequestHeader String userId) {
        final List<LandDto> lands = landAssetService.getLands(userId);
        return ResponseEntity.ok(lands);
    }

    @PutMapping
    public ResponseEntity<LandDto> updateLand(@RequestHeader String userId, @RequestBody LandDto landDto) {
        landAssetService.updateAssetLand(landDto);
        return ResponseEntity.accepted().build();
    }

    @PostMapping
    public ResponseEntity<LandDto> createLand(@RequestHeader String userId, @RequestBody LandDto landDto) {
        landAssetService.createNewAssetLand(landDto);
        return ResponseEntity.created(URI.create("")).build();
    }
}
