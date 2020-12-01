package org.purchase.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class SmsRequestDTO implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;

	private String phone;

}