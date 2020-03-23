package study.mct.api;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.mct.domain.CmsAccount;
import study.mct.domain.Merchant;
import study.mct.service.MerchantService;

@RestController
@RequiredArgsConstructor
public class MerchantApiContoller {

  private final MerchantService merchantService;

  /**
   * 1. 등록된 모든 가맹점 조회
   */

  @GetMapping("/api/allmerchant")
  public Result mechants() {
    List<Merchant> findMerchants = merchantService.findMerchants(); //엔티티 -> DTO 변환
    List<MerchantDto> collect = findMerchants.stream().map(
        m -> new MerchantDto(m.getMerchantName(), m.getMerchantCLS(), m.getMerchantFlag(),
            m.getCmsAccount().toString())).collect(
        Collectors.toList());
    return new Result(collect);

  }

  /**
   * 2. 신규 가맹점 등록
   */
  @PostMapping("/api/createMerchant")
  public CreateMerchantResponse createMerchant(@RequestBody @Valid
      CreateMerchantRequest request) {

    Merchant merchant = new Merchant();

    CmsAccount cmsAccount = new CmsAccount();
    cmsAccount.setId(request.getCmsAccountNo());

    //1. 가맹점 계좌 등록
    merchant.setCmsAccount(cmsAccount);

    //2. 가맹점명 셋팅
    merchant.setMerchantName(request.getMerchantName());

    //3. 가맹점 구분 셋팅
    if (request.getMerchantCLS().equals("COOPERATE")) {
      merchant.setMerchantCLS("COOPERATE");
    } else if (request.getMerchantCLS().equals("GENERAL")) {
      merchant.setMerchantCLS("GENERAL");
    } else if (request.getMerchantCLS().equals("OIL")) {
      merchant.setMerchantCLS("OIL");
    }

    //4. 가맹점 구분 셋팅
    if (request.getMerchantFlag().equals("CARD")) {
      merchant.setMerchantFlag("CARD");
    } else if (request.getMerchantFlag().equals("COUPON")) {
      merchant.setMerchantFlag("COUPON");
    } else if (request.getMerchantFlag().equals("WEB")) {
      merchant.setMerchantFlag("WEB");
    }

    Long id = merchantService.create(merchant);

    return new CreateMerchantResponse(id);
  }

  /**
   * 3. 가맹점 수정
   */
  @PutMapping("/api/updateMerchant/{id}")
  public UpdateMerchantResponse updateMerchant(@PathVariable("id") Long id
      , @RequestBody @Valid updateMerchantRequest request) {

    merchantService.updateMerchantName(id, request.merchantName);
    merchantService.updateMerchantCLS(id, request.merchantCLS);

    Merchant merchant = merchantService.findOne(id);
    return new UpdateMerchantResponse(merchant.getId(), merchant.getMerchantName(),
        merchant.getMerchantCLS());
  }

  @Data
  static class CreateMerchantRequest {

    @NotEmpty
    private String merchantName; // 가맹점명
    @NotEmpty
    private String merchantCLS; // 가맹점분류
    @NotEmpty
    private String merchantFlag; // 가맹점 FG
    private String cmsAccountNo;
  }

  @Data
  static class updateMerchantRequest {

    private String merchantName;
    private String merchantCLS;


  }

  @Data
  @AllArgsConstructor
  static class Result<T> {

    private T data;
  }

  @Data
  class CreateMerchantResponse {

    private Long id;

    public CreateMerchantResponse(Long id) {
      this.id = id;
    }
  }

  @Data
  @AllArgsConstructor
  class UpdateMerchantResponse {

    private Long id;
    private String merchantName;
    private String merchantCLS;

  }

  @Data
  @AllArgsConstructor
  class MerchantDto {

    private String merchantName;
    private String merchantCLS;
    private String merchantFlag;
    private String cmsAccount;
  }
}
